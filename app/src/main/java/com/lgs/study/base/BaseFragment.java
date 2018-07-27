package com.lgs.study.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lgs.study.utils.InjectHelper;
import com.lscs.lgs.annotationlib.annotation.ContentView;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;


/**
 * Created by admin on 2018/4/19.
 */

public abstract class BaseFragment extends RxFragment implements IView {
    private View mView;
    private Boolean hasInitData = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int inject = InjectHelper.inject(this);
        mView = inflater.inflate(inject, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!hasInitData) {
            initData();
            initEvent();
            hasInitData = true;
        }
    }

    protected void initEvent() {

    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) mView.getParent()).removeView(mView);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
}
