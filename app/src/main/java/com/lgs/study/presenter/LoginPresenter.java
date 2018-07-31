package com.lgs.study.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.google.gson.Gson;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.lgs.study.activity.MainActivity;
import com.lgs.study.R;
import com.lgs.study.base.RxPresenter;
import com.lgs.study.bean.LoginBean;
import com.lgs.study.cons.Constants;
import com.lgs.study.cons.Url;
import com.lgs.study.model.RetrofitHelper;
import com.lgs.study.utils.RuleUtils;
import com.lgs.study.utils.RxBus;
import com.lgs.study.utils.SPUtils;
import com.lgs.study.utils.ShowUtils;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by admin on 2018/4/26.
 */

public class LoginPresenter extends RxPresenter {
    @Inject
    public LoginPresenter(RetrofitHelper httpHelper) {
        super(httpHelper);
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
     * 控制登录按钮是否可点击
     *
     * @param phone
     * @param psd
     * @param view
     */
    public void enableBtnLogin(EditText phone, final EditText psd, final View view) {
        Observable<CharSequence> ObservableName = RxTextView.textChanges(phone);
        Observable<CharSequence> ObservablePassword = RxTextView.textChanges(psd);

        Observable.combineLatest(ObservableName, ObservablePassword, new BiFunction<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean apply(CharSequence phone, CharSequence password) throws Exception {
                return RuleUtils.isPhone(phone.toString()) && RuleUtils.isPassword(password.toString());
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                view.setEnabled(aBoolean);
            }
        });
    }

    /**
     * 手机长度为11时,密码获取焦点
     *
     * @param phone
     * @param psd
     */
    public void requestEditPwdFocus(EditText phone, final EditText psd) {
        RxTextView.textChanges(phone).map(new Function<CharSequence, Boolean>() {
            @Override
            public Boolean apply(CharSequence charSequence) throws Exception {
                return charSequence.length() == 11;
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
     * 请求登录接口
     *
     * @param phone
     * @param psd
     */
    public void requestLogin(String phone, String psd) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("loginType", "1");
        hashMap.put("userLoginKey", phone);
        hashMap.put("userPassword", psd);
        loadNetData(Url.login, hashMap, 0, false);
    }

    /**
     * 登录成功
     *
     * @param activity
     * @param s
     */
    public void doForLoginSuccess(Activity activity, String s) {
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(s, LoginBean.class);
        SPUtils.put(Constants.name, loginBean.getUserLikename());
        SPUtils.put(Constants.number, loginBean.getUserNumber());
        SPUtils.put(Constants.logo, loginBean.getUserImg());
        MainActivity.actionStart(activity);
    }

    public void onChangePasswordSuccess(final Activity activity) {
        RxBus.getDefault().toDefaultFlowable(String.class, new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                if (TextUtils.equals(activity.getString(R.string.change_pwd_success),s)||TextUtils.equals(activity.getString(R.string.regist_success),s)) {
                    ShowUtils.showSnackBar(activity,s);
                }
            }
        });
    }
}
