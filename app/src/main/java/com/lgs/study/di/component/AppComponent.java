package com.lgs.study.di.component;

import com.lgs.study.di.module.AppModule;
import com.lgs.study.di.module.HttpModule;
import com.lgs.study.globe.App;
import com.lgs.study.model.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by admin on 2018/4/23.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    void inject(App app);
    App getApplication();
    RetrofitHelper retrofitHelper();  //提供http的帮助类
}
