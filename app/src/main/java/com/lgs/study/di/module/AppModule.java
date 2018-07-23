package com.lgs.study.di.module;

import android.app.Application;

import com.lgs.study.globe.App;
import com.lgs.study.globe.AppDelegate;
import com.lgs.study.model.HttpHelper;
import com.lgs.study.model.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/4/23.
 */
@Module
public class AppModule {
    private App context;

    public AppModule(App app){
        this.context = app;
    }
    @Provides
    AppDelegate providesAppDelegate(){
        return new AppDelegate(context);
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return context;
    }
    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }
}
