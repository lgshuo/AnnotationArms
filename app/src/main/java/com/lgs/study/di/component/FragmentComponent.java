package com.lgs.study.di.component;

import android.app.Activity;


import com.lgs.study.di.module.FragmentModule;
import com.lgs.study.di.scope.FragmentScope;
import com.lgs.study.fragment.NovalFragment;
import com.lgs.study.fragment.StoryFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(StoryFragment storyFragment);

    void inject(NovalFragment novalFragment);
}
