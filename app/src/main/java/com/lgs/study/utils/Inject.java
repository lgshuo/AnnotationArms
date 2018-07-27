package com.lgs.study.utils;

/**
 * Created by JokAr on 16/8/6.
 */
public interface Inject<T> {

    void injectSuccess(T host, String url, int type, String result) throws Exception;

    void injectFaild(T host, String url, int type, String result) throws Exception;
//    void injectSuccess(T host, Object object, Provider provider);
}
