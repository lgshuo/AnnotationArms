package com.lgs.study.globe;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.lgs.study.di.component.AppComponent;
import com.lgs.study.di.component.DaggerAppComponent;
//import com.lgs.study.di.module.AppModule;
import com.lgs.study.di.module.AppModule;
import com.lgs.study.di.module.HttpModule;

import javax.inject.Inject;

/**
 * Created by admin on 2018/4/19.
 */

public class App extends Application {
    @Inject
    AppDelegate mAppDelegate;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    public static App getInstance() {
        return mInstance;
    }

    private static App mInstance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        DaggerAppComponent.builder().appModule(new AppModule(this)).build().inject(this);
        mAppDelegate.attachBaseContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getScreenSize();
        mInstance = this;
        if (mAppDelegate != null) {
            mAppDelegate.onCreate();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppDelegate != null) {
            mAppDelegate.onTerminate();
        }
    }

    public static AppComponent getAppComponent(){
        return DaggerAppComponent.builder().appModule(new AppModule(mInstance)).httpModule(new HttpModule()).build();
    }


    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
}
