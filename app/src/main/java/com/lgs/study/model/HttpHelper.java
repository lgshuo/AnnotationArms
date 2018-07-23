package com.lgs.study.model;


import java.util.HashMap;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/23.
 */

public interface HttpHelper {
    Flowable<ResponseBody> loadNetData(String url, HashMap<String, String> params, int type);
}
