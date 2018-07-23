package com.lgs.study.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.lgs.study.globe.App;


/**
 * Created by ASUS on 2017/8/26.
 */
public class SPUtils {
    /**
     * 保存在手机里面的文件名
     */
    public static final String FILE_NAME = "liaoke_data";

    /**
     * 加密数据,并保存到sp中
     *
     * @param key
     * @param object
     */
    public static void put(String key, Object object) {

        SharedPreferences sp = App.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            key = AESHelper.encrypt(key, FILE_NAME);
            editor.putString(key, AESHelper.encrypt((String) object, FILE_NAME));
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }


        editor.commit();
    }

    /**
     * 解密数据并取出
     *
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object get(String key, Object defaultObject) {
        SharedPreferences sp = App.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            String result = sp.getString(AESHelper.encrypt(key, FILE_NAME), (String) defaultObject);
            if (TextUtils.isEmpty(result)) {
                return "";
            }
            return AESHelper.decrypt(result, FILE_NAME);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }
        return null;
    }

    /**
     * 加密数据,并保存到sp中
     *
     * @param key
     */
    public static void remove(String key) {

        SharedPreferences sp = App.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }
    /**
     * 清除sp的数据
     */
    public static void clear() {
        SharedPreferences sp = App.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }
}