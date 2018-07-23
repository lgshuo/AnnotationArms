package com.lgs.study.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.lgs.study.globe.App;

/**
 * Created by admin on 2018/4/20.
 */

public class ShowUtils {
    private static Toast mToast;

    public static void showSnackBar(Activity activity, String content) {
        View view = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(view, content, 3000).show();
    }

    public static void showSnackBar(View view, String content) {
        Snackbar.make(view, content, 3000).show();
    }

    public static void showToast(String s) {
        if (mToast == null) {
            synchronized (ShowUtils.class) {
                mToast = Toast.makeText(App.getInstance(), s, Toast.LENGTH_SHORT);
            }
        } else {
            mToast.setText(s);
        }
        mToast.show();
    }
}
