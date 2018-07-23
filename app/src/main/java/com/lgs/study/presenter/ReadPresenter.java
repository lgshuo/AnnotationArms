package com.lgs.study.presenter;

import android.Manifest;
import android.app.Activity;

import com.lgs.study.base.RxPresenter;
import com.lgs.study.cons.Url;
import com.lgs.study.model.RetrofitHelper;

import java.security.Permissions;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/30/030.
 */

public class ReadPresenter extends RxPresenter {
    @Inject
    public ReadPresenter(RetrofitHelper httpHelper) {
        super(httpHelper);
    }

    public void requestText(){
        loadNetData(Url.txt,new HashMap<String, String>());
    }

}
