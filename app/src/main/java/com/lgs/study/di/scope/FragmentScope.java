package com.lgs.study.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by admin on 2018/4/23.
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
