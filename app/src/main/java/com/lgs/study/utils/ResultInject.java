package com.lgs.study.utils;

import android.support.v4.util.ArrayMap;


/**
 * Created by JokAr on 16/8/6.
 */
public class ResultInject {
    private static final ArrayMap<String, Inject> injectMap = new ArrayMap<>();

    public static void injectSuccess(Object host, String url, int type, String result) {
        String className = host.getClass().getName();
        try {
            Inject inject = injectMap.get(className);

            if (inject == null) {
                Class<?> aClass = Class.forName(className + "$$ResultInject");
                inject = (Inject) aClass.newInstance();
                injectMap.put(className, inject);
            }
            inject.injectSuccess(host, url, type,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void injectFaild(Object host, String url, int type, String result) {
        String className = host.getClass().getName();
        try {
            Inject inject = injectMap.get(className);

            if (inject == null) {
                Class<?> aClass = Class.forName(className + "$$ResultInject");
                inject = (Inject) aClass.newInstance();
                injectMap.put(className, inject);
            }
            inject.injectFaild(host, url, type,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
