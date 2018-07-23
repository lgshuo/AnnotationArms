package com.lgs.study.base;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lgs.study.annotations.utils.InjectUtils;
import com.lgs.study.globe.App;
import com.lgs.study.model.HttpHelper;
import com.lgs.study.model.RetrofitHelper;
import com.lgs.study.utils.ACache;
import com.lgs.study.utils.ShowUtils;
import com.trello.rxlifecycle2.LifecycleProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.ResponseBody;

/**
 * Created by codeest on 2016/8/2.
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */
public class RxPresenter implements BasePresenter {
    private HttpHelper mHttpHelper;
    protected IView mView;
    ACache mCahce = ACache.get(App.getInstance());
    @Inject
    public RxPresenter(RetrofitHelper httpHelper) {
        this.mHttpHelper = httpHelper;
    }

    @Override
    public void attachView(IView view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    public void loadNetData(final String url, HashMap<String, String> params) {
        loadNetData(url, params, 0, true);
    }


    public void loadNetData(final String url,final HashMap<String, String> params, int type, final boolean needCache) {
        final String cacheKey = url + params.toString();
        Flowable<String> cacheFlowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                String cache = mCahce.getAsString(cacheKey);
                if (cache != null&&needCache) {
                    e.onNext(cache);
                    e.onComplete();
                } else {
                    e.onComplete();
                }

            }
        }, BackpressureStrategy.BUFFER);


        Flowable<String> netFlowable = mHttpHelper.loadNetData(url, params, type).map(new Function<ResponseBody, String>() {

            @Override
            public String apply(ResponseBody responseBody) throws Exception {
                String string = responseBody.string();
                if (needCache) {
                    mCahce.put(cacheKey, string);
                }
                return string;
            }
        });

        Flowable<String> resultFlowable = Flowable.concat(cacheFlowable, netFlowable);

        if (mView instanceof LifecycleProvider) {
            resultFlowable.compose(((LifecycleProvider) mView).bindToLifecycle());
        }
        resultFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<String>() {
                    @Override
                    public void onNext(String s) {
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            int errcode = jsonObject.getInt("errcode");
                            String errmsg = jsonObject.getString("errmsg");
                            if (errcode == 0) {
                                InjectUtils.injectOnSuccess(mView,url,s);
                            } else {
                                if (mView instanceof Activity) {
                                    ShowUtils.showSnackBar((Activity) mView,errmsg);
                                } else if (mView instanceof Fragment) {
                                    ShowUtils.showSnackBar(((Fragment) mView).getActivity(),errmsg);
                                }
                                InjectUtils.injectOnError(mView,url,s);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        InjectUtils.injectOnFaild(mView,url,t);
                        if (mView instanceof Activity) {
                            ShowUtils.showSnackBar((Activity) mView,t.getMessage());
                        } else if (mView instanceof Fragment) {
                            ShowUtils.showSnackBar(((Fragment) mView).getActivity(),t.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public Flowable<View> makeBtnClickFirst(final View view){
      return   Flowable.create(new FlowableOnSubscribe<View>() {
            @Override
            public void subscribe(FlowableEmitter<View> e) throws Exception {
                e.onNext(view);
            }
        }, BackpressureStrategy.BUFFER)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
