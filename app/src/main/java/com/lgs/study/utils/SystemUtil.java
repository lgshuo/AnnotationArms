package com.lgs.study.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.lgs.study.globe.App;

/**
 * Created by admin on 2018/4/19.
 */

public class SystemUtil {
    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
