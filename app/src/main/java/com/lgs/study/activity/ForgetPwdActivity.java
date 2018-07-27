package com.lgs.study.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lgs.study.R;
import com.lgs.study.base.BaseHttpActivity;
import com.lgs.study.cons.Constants;
import com.lgs.study.cons.Url;
import com.lgs.study.presenter.ForgetPwdPresenter;
import com.lgs.study.utils.RxBus;
import com.lgs.study.utils.SPUtils;
import com.lgs.study.utils.ShowUtils;
import com.lscs.lgs.annotationlib.annotation.ContentView;
import com.lscs.lgs.annotationlib.annotation.onSuccess;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * Created by admin on 2018/4/26.
 */
@ContentView(R.layout.activity_forget_pwd)
public class ForgetPwdActivity extends BaseHttpActivity<ForgetPwdPresenter> {
    @BindView(R.id.iv_bg_login)
    ImageView mIvBgLogin;
    @BindView(R.id.et_login_phone)
    EditText mEtLoginPhone;
    @BindView(R.id.et_login_confirmation)
    EditText mEtLoginConfirmation;
    @BindView(R.id.btn_get_confirmation)
    Button mBtnGetConfirmation;
    @BindView(R.id.et_login_password)
    EditText mEtLoginPassword;
    @BindView(R.id.btn_login_commit)
    Button mBtnLoginCommit;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    public void initData() {
        mPresenter.startAnim(mIvBgLogin);
    }

    public void initEvent() {

        mPresenter.enableBtnConfirmation(mEtLoginPhone, mBtnGetConfirmation);
        mPresenter.changeFocus(mEtLoginPhone, mEtLoginConfirmation, 11);
        mPresenter.changeFocus(mEtLoginConfirmation, mEtLoginPassword, 6);
        mPresenter.enableBtnLogin(mEtLoginPhone, mEtLoginConfirmation, mEtLoginPassword, mBtnLoginCommit);
    }


    @OnClick({R.id.btn_get_confirmation, R.id.btn_login_commit})
    public void onViewClicked(View view) {
        mPresenter.makeBtnClickFirst(view).subscribe(new Consumer<View>() {
            @Override
            public void accept(View view) throws Exception {
                switch (view.getId()) {
                    case R.id.btn_get_confirmation:
                        mPresenter.requestGetConfrim(mEtLoginPhone.getText().toString());
                        break;
                    case R.id.btn_login_commit:
                        mPresenter.requestCommit(mEtLoginPhone.getText().toString(),mEtLoginConfirmation.getText().toString(),mEtLoginPassword.getText().toString());
                        break;
                }
            }
        });
    }
    @onSuccess(url = Url.getConfirm)
    public void requestGetConfrimSuccess(String s) {
        mPresenter.countDown(mBtnGetConfirmation);
    }

    @onSuccess(url = Url.forgetPwd)
    public void requestCommitSuccess(String s) {
        finish();
        SPUtils.put(Constants.phone,mEtLoginPhone.getText().toString());
        SPUtils.put(Constants.pwd,mEtLoginPassword.getText().toString());
        RxBus.getDefault().post(getString(R.string.change_pwd_success));
    }
}
