package com.lgs.study.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lgs.study.R;
import com.lgs.study.base.BaseHttpActivity;
import com.lgs.study.cons.Constants;
import com.lgs.study.cons.Url;
import com.lgs.study.presenter.LoginPresenter;
import com.lgs.study.utils.SPUtils;
import com.lgs.study.utils.ShowUtils;
import com.lscs.lgs.annotationlib.annotation.ContentView;
import com.lscs.lgs.annotationlib.annotation.onSuccess;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by admin on 2018/4/26.
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseHttpActivity<LoginPresenter> {
    @BindView(R.id.iv_bg_login)
    ImageView mIvBgLogin;
    @BindView(R.id.et_login_phone)
    EditText mEtLoginPhone;
    @BindView(R.id.et_login_password)
    EditText mEtLoginPassword;
    @BindView(R.id.btn_login_sign)
    Button mBtnLoginSign;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);

    }

    public void initData() {
        mPresenter.startAnim(mIvBgLogin);
        mEtLoginPassword.setText((String) SPUtils.get(Constants.pwd,""));
        mEtLoginPhone.setText((String) SPUtils.get(Constants.phone,""));
    }

    public void initEvent() {
        mPresenter.enableBtnLogin(mEtLoginPhone, mEtLoginPassword, mBtnLoginSign);
        mPresenter.requestEditPwdFocus(mEtLoginPhone, mEtLoginPassword);
        mPresenter.onChangePasswordSuccess(this);
    }

    @OnClick({R.id.btn_login_sign, R.id.tv_login_forgot, R.id.tv_login_register})
    public void onViewClicked(final View view) {
        mPresenter.makeBtnClickFirst(view)
                .subscribe(new Consumer<View>() {
                    @Override
                    public void accept(View view) throws Exception {
                        switch (view.getId()) {
                            case R.id.btn_login_sign:
                                mPresenter.requestLogin(mEtLoginPhone.getText().toString(),mEtLoginPassword.getText().toString());
                                break;
                            case R.id.tv_login_forgot:
                                startActivity(ForgetPwdActivity.class);
                                break;
                            case R.id.tv_login_register:
                                startActivity(RegistActivity.class);
                                break;
                        }
                    }
                });
    }

    public static void actionStart(Activity context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    @onSuccess(url = Url.login)
    public void requestLoginSuccess(String s){
        mPresenter.doForLoginSuccess(this,s);
        SPUtils.put(Constants.phone,mEtLoginPhone.getText().toString());
        SPUtils.put(Constants.pwd,mEtLoginPassword.getText().toString());
    }
}
