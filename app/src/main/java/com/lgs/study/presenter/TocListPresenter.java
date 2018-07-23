package com.lgs.study.presenter;

import com.lgs.study.base.RxPresenter;
import com.lgs.study.cons.Url;
import com.lgs.study.model.RetrofitHelper;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/1/001.
 */

public class TocListPresenter extends RxPresenter {
    @Inject
    public TocListPresenter(RetrofitHelper httpHelper) {
        super(httpHelper);
    }

    public void requestTocList(String book_id) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bookId", book_id);
        loadNetData(Url.book_title, hashMap);
    }
}
