package com.lgs.study.di.module;

import com.lgs.study.globe.App;
import com.lgs.study.globe.AppDelegate;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/4/23.
 */
@Module
public class AppDelegateModule {
    private App context;

    public AppDelegateModule(App app){
        this.context = app;
    }
    @Provides
    AppDelegate providesAppDelegate(){
        return new AppDelegate(context);
    }
}
