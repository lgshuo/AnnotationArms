package com.lgs.study.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lgs.study.di.component.ActivityComponent;
import com.lgs.study.di.component.DaggerActivityComponent;
import com.lgs.study.di.module.ActivityModule;
import com.lgs.study.globe.App;

import javax.inject.Inject;

/**
 * Created by admin on 2018/4/23.
 */

public abstract class BaseHttpActivity<T extends BasePresenter> extends BaseActivity {
    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onCreate(savedInstanceState);
    }

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }
    protected abstract void initInject();

}
