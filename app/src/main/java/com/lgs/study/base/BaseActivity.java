package com.lgs.study.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.lgs.study.R;
import com.lgs.study.activity.ForgetPwdActivity;
import com.lgs.study.activity.LoginActivity;
import com.lgs.study.activity.ReadActivity;
import com.lgs.study.activity.RegistActivity;
import com.lgs.study.activity.StartActivity;
import com.lgs.study.activity.TocListActivity;
import com.lgs.study.annotations.utils.InjectUtils;
import com.lgs.study.utils.InjectHelper;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.Arrays;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by admin on 2018/4/19.
 */

public class BaseActivity extends RxAppCompatActivity implements IView {
    private Class<Activity>[] cls = new Class[]{StartActivity.class, LoginActivity.class, ForgetPwdActivity.class, RegistActivity.class, ReadActivity.class};
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImmersionBar = ImmersionBar.with(this);
        InjectUtils.inject(this);
        if (Arrays.asList(cls).contains(getClass())) {
            mImmersionBar
                    .transparentBar()
                    .init();
        } else {
            mImmersionBar
                    .statusBarColor(R.color.statusbarColor)
                    .init();
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        ButterKnife.bind(this);
        InjectUtils.injectInitData(this);
        InjectUtils.injectInitEvent(this);

    }

    protected void startActivity(Class<? extends Activity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImmersionBar.destroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
