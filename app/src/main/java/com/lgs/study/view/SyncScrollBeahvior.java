package com.lgs.study.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.lgs.study.R;

public class SyncScrollBeahvior extends CoordinatorLayout.Behavior<View> {

    public SyncScrollBeahvior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL)
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy > 0 && child.isShown()) {
            Animation animation = AnimationUtils.loadAnimation(child.getContext(), R.anim.scale_in);
            child.startAnimation(animation);
            child.setVisibility(View.INVISIBLE);
        } else if (dy < 0 && !child.isShown()) {
            Animation animation = AnimationUtils.loadAnimation(child.getContext(), R.anim.scale_out);
            child.startAnimation(animation);
            child.setVisibility(View.VISIBLE);
        }

    }


}