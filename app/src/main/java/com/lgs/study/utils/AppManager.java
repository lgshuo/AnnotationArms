package com.lgs.study.utils;

import android.app.Activity;
import android.text.TextUtils;

import com.lgs.study.globe.App;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by admin on 2018/4/20.
 */

public class AppManager {
    private static Stack<Activity> mStack;
    private static Activity mCurrentActivity;

    /**
     * 添加activity
     *
     * @param activity
     */
    public static synchronized void addActivity(Activity activity) {
        if (mStack == null) {
            synchronized (AppManager.class) {
                mStack = new Stack<>();
                mStack.add(activity);
            }
        } else {
            synchronized (AppManager.class) {
                mStack.add(activity);
            }
        }
    }

    /**
     * 删除集合里的指定activity
     */
    public static synchronized void removeActivity(Activity activity) {
        if (mStack != null && activity != null) {
            synchronized (AppManager.class) {
                mStack.remove(activity);
            }
        }
    }

    /**
     * 杀死指定的activity
     */
    public static synchronized void killActivity(Class<Activity> clazz) {
        for (int i = mStack.size() - 1; i >= 0; i--) {
            if (mStack.get(i).getClass() == clazz) {
                mStack.get(i).finish();
                mStack.remove(i);
            }
        }
    }

    /**
     * 退出app
     */
    public static synchronized void exitApp(){
        if (mStack != null) {
            synchronized (AppManager.class) {
                for (int i = mStack.size() - 1; i >= 0; i--) {
                    mStack.get(i).finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


}
