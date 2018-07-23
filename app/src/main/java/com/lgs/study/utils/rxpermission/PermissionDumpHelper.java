package com.lgs.study.utils.rxpermission;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class PermissionDumpHelper {

    public static void dumpFordivce(Activity activity, String deviceName) {
        if ("HUAWEI".equals(deviceName)) {
            goHuaWeiMainager(activity);
        } else if ("vivo".equals(deviceName)) {
            goVivoMainager(activity);
        } else if ("OPPO".equals(deviceName)) {
            goOppoMainager(activity);
        } else if ("Coolpad".equals(deviceName)) {
            goCoolpadMainager(activity);
        } else if ("Meizu".equals(deviceName)) {
            goMeizuMainager(activity);
            // getAppDetailSettingIntent();
        } else if ("Xiaomi".equals(deviceName)) {
            goXiaoMiMainager(activity);
        } else if ("samsung".equals(deviceName)) {
            goSangXinMainager(activity);
        } else {
            goIntentSetting(activity);
        }
    }

    private static void goHuaWeiMainager(Activity activity) {
        try {
            Intent intent = new Intent("demo.vincent.com.tiaozhuan");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
            intent.setComponent(comp);
            activity.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(activity, "跳转失败", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            goIntentSetting(activity);
        }
    }

    private static void goXiaoMiMainager(Activity activity) {
        try {
            Intent localIntent = new Intent(
                    "miui.intent.action.APP_PERM_EDITOR");
            localIntent
                    .setClassName("com.miui.securitycenter",
                            "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            localIntent.putExtra("extra_pkgname", activity.getPackageName());
            activity.startActivity(localIntent);
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            goIntentSetting(activity);
        }
    }

    private static void goMeizuMainager(Activity activity) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.putExtra("packageName", "xiang.settingpression");
            activity.startActivity(intent);
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            localActivityNotFoundException.printStackTrace();
            goIntentSetting(activity);
        }
    }

    private static void goSangXinMainager(Activity activity) {
        //三星4.3可以直接跳转
        goIntentSetting(activity);
    }

    private static void goIntentSetting(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void goOppoMainager(Activity activity) {
        doStartApplicationWithPackageName(activity,"com.coloros.safecenter");
    }

    /**
     * doStartApplicationWithPackageName("com.yulong.android.security:remote")
     * 和Intent open = getPackageManager().getLaunchIntentForPackage("com.yulong.android.security:remote");
     * startActivity(open);
     * 本质上没有什么区别，通过Intent open...打开比调用doStartApplicationWithPackageName方法更快，也是android本身提供的方法
     * @param activity
     */
    private static void goCoolpadMainager(Activity activity) {
        doStartApplicationWithPackageName(activity,"com.yulong.android.security:remote");
      /*  Intent openQQ = getPackageManager().getLaunchIntentForPackage("com.yulong.android.security:remote");
        startActivity(openQQ);*/
    }

    //vivo
    private static void goVivoMainager(Activity activity) {
        doStartApplicationWithPackageName(activity,"com.bairenkeji.icaller");
     /*   Intent openQQ = getPackageManager().getLaunchIntentForPackage("com.vivo.securedaemonservice");
        startActivity(openQQ);*/
    }

    /**
     * 此方法在手机各个机型设置中已经失效
     *
     * @return
     */
    private static Intent getAppDetailSettingIntent(Activity activity) {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", activity.getPackageName());
        }
        return localIntent;
    }

    private static void doStartApplicationWithPackageName(Activity activity, String packagename) {

        // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
        PackageInfo packageinfo = null;
        try {
            packageinfo = activity.getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageinfo == null) {
            return;
        }
        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(packageinfo.packageName);
        // 通过getPackageManager()的queryIntentActivities方法遍历
        List<ResolveInfo> resolveinfoList = activity.getPackageManager()
                .queryIntentActivities(resolveIntent, 0);
        Log.i("MainActivity", "resolveinfoList" + resolveinfoList.size());
        for (int i = 0; i < resolveinfoList.size(); i++) {
            Log.i("MainActivity", resolveinfoList.get(i).activityInfo.packageName + resolveinfoList.get(i).activityInfo.name);
        }
        ResolveInfo resolveinfo = resolveinfoList.iterator().next();
        if (resolveinfo != null) {
            // packagename = 参数packname
            String packageName = resolveinfo.activityInfo.packageName;
            // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
            String className = resolveinfo.activityInfo.name;
            // LAUNCHER Intent
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            // 设置ComponentName参数1:packagename参数2:MainActivity路径
            ComponentName cn = new ComponentName(packageName, className);
            intent.setComponent(cn);
            try {
                activity.startActivity(intent);
            } catch (Exception e) {
                goIntentSetting(activity);
                e.printStackTrace();
            }
        }
    }
}
