package com.lgs.study.presenter;

import com.lgs.study.base.RxPresenter;
import com.lgs.study.cons.Url;
import com.lgs.study.model.RetrofitHelper;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/4/28/028.
 */

public class NovalPresenter extends RxPresenter {
    @Inject
    public NovalPresenter(RetrofitHelper httpHelper) {
        super(httpHelper);
    }

    public void requestRecommend() {
        HashMap<String, String> hashMap = new HashMap<>();
        loadNetData(Url.recommend, hashMap);
    }
}
