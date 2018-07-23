package com.lgs.study.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.annotations.utils.InjectUtils;
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
        ContentView contentView = getClass().getAnnotation(ContentView.class);//获取该类ContentView的注解
        //如果有注解
        int viewId = 0;
        if(contentView!=null){
             viewId=contentView.value();//获取注解类参数
        }
        mView = inflater.inflate(viewId, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!hasInitData) {
            InjectUtils.injectInitData(this);
            InjectUtils.injectInitEvent(this);
            hasInitData = true;
        }
    }
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
