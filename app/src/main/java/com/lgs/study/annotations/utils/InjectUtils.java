package com.lgs.study.annotations.utils;

import android.app.Activity;
import android.app.Dialog;

import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.annotations.socpe.initData;
import com.lgs.study.annotations.socpe.initEvent;
import com.lgs.study.annotations.socpe.onError;
import com.lgs.study.annotations.socpe.onFaild;
import com.lgs.study.annotations.socpe.onSuccess;
import com.lgs.study.base.IView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InjectUtils {
    public static final String ACTIVITY_MAIN_CONTENTVIEW="setContentView";

    /**
     * 注入所有
     * @param activity
     */
    public static void inject(Activity activity){
        injectContentView(activity);
    }

    /**
     * 注入ContentView
     * @param activity
     */
    public static void injectContentView(Activity activity){
        Class<? extends Activity> clazz = activity.getClass();//获取该类信息
        ContentView contentView = clazz.getAnnotation(ContentView.class);//获取该类ContentView的注解
        //如果有注解
        if(contentView!=null){
            int viewId=contentView.value();//获取注解类参数
            try {
                Method method=clazz.getMethod(ACTIVITY_MAIN_CONTENTVIEW,int.class);//获取该方法的信息
                method.setAccessible(true);//获取该方法的访问权限
                method.invoke(activity,viewId);//调用该方法的，并设置该方法参数
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 注入ContentView
     * @param dialog
     */
    public static void injectContentView(Dialog dialog){
        Class<? extends Dialog> clazz = dialog.getClass();//获取该类信息
        ContentView contentView = clazz.getAnnotation(ContentView.class);//获取该类ContentView的注解
        //如果有注解
        if(contentView!=null){
            int viewId=contentView.value();//获取注解类参数
            try {
                Method method=clazz.getMethod(ACTIVITY_MAIN_CONTENTVIEW,int.class);//获取该方法的信息
                method.setAccessible(true);//获取该方法的访问权限
                method.invoke(dialog,viewId);//调用该方法的，并设置该方法参数
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化数据
     * @param iViewInit
     */

    public static void injectInitData(IView iViewInit) {
        Class<? extends IView> clazz = iViewInit.getClass();
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            initData initData = methods[i].getAnnotation(initData.class);
            if (initData != null) {
                try {
                    methods[i].invoke(iViewInit);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 初始化点击事件
     * @param iViewInit
     */
    public static void injectInitEvent(IView iViewInit) {
        Class<? extends IView> clazz = iViewInit.getClass();
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            initEvent initEvent = methods[i].getAnnotation(initEvent.class);
            if (initEvent != null) {
                try {
                    methods[i].invoke(iViewInit);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 访问网络成功回调
     */

    public static void injectOnSuccess(IView iView, String url, Object object) {
        Class<? extends IView> aClass = iView.getClass();
        Method[] methods = aClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            onSuccess annotation = methods[i].getAnnotation(onSuccess.class);
            if (annotation!=null) {
                if (annotation.url()==url) {
                    try {
                        methods[i].invoke(iView, object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    /**
     * 访问网络成功回调
     */

    public static void injectOnError(IView iView, String url, Object object) {
        Class<? extends IView> aClass = iView.getClass();
        Method[] methods = aClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            onError annotation = methods[i].getAnnotation(onError.class);
            if (annotation!=null) {
                if (annotation.url()==url) {
                    try {
                        methods[i].invoke(iView, object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    /**
     * 访问失败成功回调
     */

    public static void injectOnFaild(IView iView, String url, Object object) {
        Class<? extends IView> aClass = iView.getClass();
        Method[] methods = aClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            onFaild annotation = methods[i].getAnnotation(onFaild.class);
            if (annotation!=null) {
                if (annotation.url()==url) {
                    try {
                        methods[i].invoke(iView, object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}