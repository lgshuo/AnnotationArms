package com.lgs.study.di.component;

import android.app.Activity;

import com.lgs.study.activity.ForgetPwdActivity;
import com.lgs.study.activity.LoginActivity;
import com.lgs.study.activity.ReadActivity;
import com.lgs.study.activity.RegistActivity;
import com.lgs.study.activity.SearchActivity;
import com.lgs.study.activity.SearchResultActivity;
import com.lgs.study.activity.TocListActivity;
import com.lgs.study.di.module.ActivityModule;
import com.lgs.study.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(LoginActivity loginActivity);

    void inject(ForgetPwdActivity forgetPwdActivity);

    void inject(RegistActivity registActivity);

    void inject(SearchActivity searchActivity);

    void inject(SearchResultActivity searchResultActivity);

    void inject(ReadActivity readActivity);

    void inject(TocListActivity tocListActivity);
}
