package com.lgs.study.di.module;

import android.app.Activity;

import com.lgs.study.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/4/23.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
