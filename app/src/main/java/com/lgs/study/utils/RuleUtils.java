package com.lgs.study.utils;

/**
 * Created by admin on 2018/4/26.
 */

public class RuleUtils {
    public static boolean isPhone(String phone){
        return phone.length() == 11;
    }

    public static boolean isPassword(String password) {
        return password.length()>=6;
    }
}
