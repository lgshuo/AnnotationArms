package com.lgs.study.presenter;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.lgs.study.R;
import com.lgs.study.activity.LoginActivity;
import com.lgs.study.activity.StartActivity;
import com.lgs.study.base.BasePresenter;
import com.lgs.study.base.IView;
import com.lgs.study.bean.StartBean;
import com.lgs.study.utils.RxBus;

/**
 * Created by admin on 2018/4/26.
 */

public class StartPresenter implements BasePresenter {
    private StartActivity view;

    @Override
    public void attachView(IView view) {
        this.view = (StartActivity) view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    /**
     * 开启动画
     * @param startBg
     */
    public void startAnim(ImageView startBg){
        Animation animation = AnimationUtils.loadAnimation(view, R.anim.welcome_anim);
        startBg.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                LoginActivity.actionStart(view);
                view.finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 1; i < 101; i++) {
                    try {
                        sleep(30);
                        RxBus.getDefault().post(new StartBean(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
