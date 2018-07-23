package com.lgs.study.globe;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.WindowManager;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.lgs.study.R;
import com.lgs.study.activity.ForgetPwdActivity;
import com.lgs.study.activity.LoginActivity;
import com.lgs.study.activity.RegistActivity;
import com.lgs.study.activity.StartActivity;
import com.lgs.study.utils.AppManager;

import java.util.Arrays;

/**
 * Created by admin on 2018/4/20.
 */

public class AppDelegate implements Application.ActivityLifecycleCallbacks {
    private Application context;

    public AppDelegate(Application context) {
        this.context = context;
    }

    public void attachBaseContext() {

    }

    public void onCreate() {
        context.registerActivityLifecycleCallbacks(this);
    }

    public void onTerminate() {
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        AppManager.addActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        AppManager.removeActivity(activity);
    }
}
