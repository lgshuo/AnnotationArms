package com.lgs.study.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lgs.study.di.component.DaggerFragmentComponent;
import com.lgs.study.di.component.FragmentComponent;
import com.lgs.study.di.module.FragmentModule;
import com.lgs.study.globe.App;

import javax.inject.Inject;

/**
 * Created by admin on 2018/4/23.
 */

public abstract class BaseHttpFragment<T extends BasePresenter> extends BaseFragment {
    @Inject
    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }
    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }
    protected abstract void initInject();

}
