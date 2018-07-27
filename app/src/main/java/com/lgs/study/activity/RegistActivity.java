package com.lgs.study.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lgs.study.R;
import com.lgs.study.base.BaseHttpActivity;
import com.lgs.study.cons.Constants;
import com.lgs.study.cons.Url;
import com.lgs.study.presenter.RegistPrsenter;
import com.lgs.study.utils.RxBus;
import com.lgs.study.utils.SPUtils;
import com.lscs.lgs.annotationlib.annotation.ContentView;
import com.lscs.lgs.annotationlib.annotation.onSuccess;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/26/026.
 */
@ContentView(R.layout.activity_regist)
public class RegistActivity extends BaseHttpActivity<RegistPrsenter> {
    @BindView(R.id.iv_bg_login)
    ImageView mIvBgLogin;
    @BindView(R.id.et_login_phone)
    EditText mEtLoginPhone;
    @BindView(R.id.et_login_confirmation)
    EditText mEtLoginConfirmation;
    @BindView(R.id.btn_get_confirmation)
    Button mBtnGetConfirmation;
    @BindView(R.id.et_login_nickname)
    EditText mEtLoginNickname;
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
        mPresenter.changeFocus(mEtLoginConfirmation, mEtLoginNickname, 6);
        mPresenter.enableBtnLogin(mEtLoginPhone, mEtLoginConfirmation, mEtLoginNickname, mEtLoginPassword, mBtnLoginCommit);
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
                        mPresenter.requestRegist(mEtLoginPhone.getText().toString(),mEtLoginConfirmation.getText().toString(),mEtLoginNickname.getText().toString(),mEtLoginPassword.getText().toString());
                        break;
                }
            }
        });
    }

    @onSuccess(url = Url.getConfirm)
    public void requestGetComfirmSuccess(String s){
        mPresenter.countDown(mBtnGetConfirmation);
    }
    @onSuccess(url = Url.regist)
    public void requestRegistSuccess(String s) {
        finish();
        SPUtils.put(Constants.phone,mEtLoginPhone.getText().toString());
        SPUtils.put(Constants.pwd,mEtLoginPassword.getText().toString());
        RxBus.getDefault().post(getString(R.string.regist_success));
    }
}

