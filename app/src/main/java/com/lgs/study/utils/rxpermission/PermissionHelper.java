package com.lgs.study.utils.rxpermission;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

import com.lgs.study.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * Created by admin on 2018/6/20.
 */

public class PermissionHelper {


    /**
     * 读写SD卡权限
     *
     * @param activity
     * @param consumer
     */
    public static void requestForWriteEx(Activity activity, Consumer<String> consumer) {
        requestPermission(activity, consumer, true, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
    }


    /**
     * 申请权限封装
     *
     * @param activity
     * @param subscriber
     * @param isNeeded
     * @param permissions
     */
    private static void requestPermission(final Activity activity, final Consumer<String> subscriber, final boolean isNeeded, final String... permissions) {
        new RxPermissions(activity)
                .requestEach(permissions)
                .subscribeOn(AndroidSchedulers.mainThread())
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            if (subscriber != null) {
                                subscriber.accept(activity.getString(R.string.success));
                            }
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            if (isNeeded) {
                                AlertDialog alertDialog = new AlertDialog.Builder(activity).setTitle("拒绝权限,将无法正常使用app")
                                        .setMessage("前往授权")
                                        .setNegativeButton("去授权", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                                requestPermission(activity, subscriber, isNeeded, permissions);
                                            }
                                        }).create();
                                alertDialog.show();
                                alertDialog.setCancelable(false);

                            }
                        } else {
                            if (isNeeded) {
                                AlertDialog alertDialog = new AlertDialog.Builder(activity).setTitle("禁止权限,将无法正常使用app")
                                        .setMessage("前往授权")
                                        .setNegativeButton("去授权", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                                PermissionDumpHelper.dumpFordivce(activity, Build.MANUFACTURER);
                                            }
                                        }).create();
                                alertDialog.show();
                                alertDialog.setCancelable(false);

                            }
                        }
                    }
                });
    }

    public static void requestForWXLogin(final Activity activity, final Consumer<String> consumer) {
        requestPermission(activity, consumer, true, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS);
    }
}
