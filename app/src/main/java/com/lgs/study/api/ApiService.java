package com.lgs.study.api;

import java.util.HashMap;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by admin on 2018/4/19.
 */

public interface ApiService {
    String HostUrl = "http://www.baidu.com/";
    @FormUrlEncoded
    @POST()
    Flowable<ResponseBody> loadNetData(@Url String url, @FieldMap HashMap<String, String> params); //登录
}
