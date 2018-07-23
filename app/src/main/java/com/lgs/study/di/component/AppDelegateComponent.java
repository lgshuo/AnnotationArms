package com.lgs.study.di.component;

import com.lgs.study.di.module.AppDelegateModule;
import com.lgs.study.globe.App;
import com.lgs.study.globe.AppDelegate;

import dagger.Component;

/**
 * Created by admin on 2018/4/23.
 */
@Component(modules = AppDelegateModule.class)
public interface AppDelegateComponent {
    void inject(App app);
}
