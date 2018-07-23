package com.lgs.study.model;

import com.lgs.study.api.ApiService;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/23.
 */

public class RetrofitHelper implements HttpHelper{
    private ApiService mApiService;

    @Inject
    public RetrofitHelper(ApiService apiService) {
        mApiService = apiService;
    }


    @Override
    public Flowable<ResponseBody> loadNetData(String url, HashMap<String, String> params, int type) {
        return mApiService.loadNetData(url,params);
    }
}
