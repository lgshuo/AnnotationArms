package com.lgs.study.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CustomBehavior extends CoordinatorLayout.Behavior<View> {

    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 用来决定需要监听哪儿些控件或者容器的状态 监听who 什么状态change
     *
     * @param parent     父容器
     * @param child      子控件 具体代表监听dependency的View 观察者
     * @param dependency 被监听的View
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TextView || super.layoutDependsOn(parent, child, dependency);
    }

    /**
     * layoutDependsOn 返回true时被回调
     * 当被监听的View发生改变的时候回调 可在此设置相应联动动画等效果
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        // 获取被监听的View的状态 只关心 滑动位置 也就是 垂直方向
        int offset = dependency.getTop() - child.getTop();
        // 让child进行平移
        ViewCompat.offsetTopAndBottom(child, offset);
        // 旋转
        child.animate().rotation(child.getTop() * 10);
        return true;
    }
}