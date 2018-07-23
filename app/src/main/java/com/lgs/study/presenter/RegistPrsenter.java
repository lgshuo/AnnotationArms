package com.lgs.study.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.lgs.study.R;
import com.lgs.study.base.RxPresenter;
import com.lgs.study.cons.Url;
import com.lgs.study.globe.App;
import com.lgs.study.model.RetrofitHelper;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.observers.ResourceObserver;

/**
 * Created by Administrator on 2018/4/26/026.
 */

public class RegistPrsenter extends RxPresenter {
    @Inject
    public RegistPrsenter(RetrofitHelper httpHelper) {
        super(httpHelper);
    }


    /**
     * 发送消息
     *
     * @param text
     */
    public void requestGetConfrim(String text) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("userMobile", text);
        loadNetData(Url.getConfirm, hashMap, 0, false);
    }

    /**
     * 请求注册
     * @param phone
     * @param confirm
     * @param nickname
     * @param pwd
     */
    public void requestRegist(String phone, String confirm, String nickname, String pwd) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("userType", "1");
        hashMap.put("userRegType", "1");
        hashMap.put("userMobile", phone);
        hashMap.put("userMobileKey", confirm);
        hashMap.put("userLikename", nickname);
        hashMap.put("userPassword", pwd);
        loadNetData(Url.regist,hashMap,0,false);
    }

    /**
     * 背景动画
     *
     * @param view
     */
    public void startAnim(View view) {
        Animation animation = AnimationUtils.loadAnimation((Context) mView, R.anim.translate_anim);
        view.startAnimation(animation);
    }

    /**
     * 验证码是否可以点击
     *
     * @param phone
     * @param btn
     */
    public void enableBtnConfirmation(final EditText phone, final Button btn) {
        Observable<CharSequence> observableName = RxTextView.textChanges(phone);
        Observable<CharSequence> observablePassword = RxTextView.textChanges(btn);

        Observable.combineLatest(observableName, observablePassword, new BiFunction<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean apply(CharSequence phone, CharSequence password) throws Exception {
                return phone.length() == 11 && TextUtils.equals(password.toString(), App.getInstance().getString(R.string.get_confirmation));
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                btn.setEnabled(aBoolean);
            }
        });

    }

    /**
     * 注册按钮是否可点击
     * @param phone
     * @param confirm
     * @param nickName
     * @param pwd
     * @param btn
     */
    public void enableBtnLogin(EditText phone, EditText confirm,EditText nickName, EditText pwd, final Button btn) {
        Observable<CharSequence> observablePhone = RxTextView.textChanges(phone);
        Observable<CharSequence> observableConfirm = RxTextView.textChanges(confirm);
        Observable<CharSequence> observablePwd = RxTextView.textChanges(pwd);
        Observable<CharSequence> observableNickName = RxTextView.textChanges(nickName);

        Observable.combineLatest(observablePhone, observableConfirm, observablePwd, observableNickName,new Function4<CharSequence, CharSequence, CharSequence,CharSequence, Boolean>() {
            @Override
            public Boolean apply(CharSequence phone, CharSequence confirm, CharSequence pwd,CharSequence nickName) throws Exception {
                return phone.length() == 11 && confirm.length() == 6 && !TextUtils.isEmpty(pwd.toString())&&!TextUtils.isEmpty(nickName);
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                btn.setEnabled(aBoolean);
            }
        });
    }

    /**
     * 切换焦点
     *
     * @param phone
     * @param psd
     */
    public void changeFocus(final EditText phone, final EditText psd, final int length) {
        RxTextView.textChanges(phone).map(new Function<CharSequence, Boolean>() {
            @Override
            public Boolean apply(CharSequence charSequence) throws Exception {
                return charSequence.length() == length;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {
                    psd.requestFocus();
                }
            }
        });
    }
    /**
     * 倒计时
     * @param btn
     */
    public void countDown(final TextView btn) {
        Observable.interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(60)
                .subscribeWith(new ResourceObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        btn.setText((60 - aLong) + App.getInstance().getString(R.string.secound));
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        btn.setText(App.getInstance().getString(R.string.get_confirmation));
                    }
                });
    }
}
