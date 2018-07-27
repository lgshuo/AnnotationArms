package com.lgs.study.utils;

import android.app.Activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *
 */

public class InjectHelper {
    public static int inject(Object host) {
        String classFullName = host.getClass().getName() + "$$ViewInjector";
        int layoutId = 0;
        try {
            Class proxy = Class.forName(classFullName);
            Constructor constructor = proxy.getConstructor();
            Object o = constructor.newInstance();
            Method method = proxy.getMethod("getLayoutId");
            layoutId= (int) method.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return layoutId;
    }
}
