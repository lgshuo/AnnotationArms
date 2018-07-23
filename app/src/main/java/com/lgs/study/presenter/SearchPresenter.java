package com.lgs.study.presenter;

import com.lgs.study.base.RxPresenter;
import com.lgs.study.cons.Url;
import com.lgs.study.model.RetrofitHelper;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/4/29/029.
 */

public class SearchPresenter extends RxPresenter {

    @Inject
    public SearchPresenter(RetrofitHelper httpHelper) {
        super(httpHelper);
    }

    public void requestForSearchRecommend() {
        loadNetData(Url.novalType, new HashMap<String, String>());
    }

    public String[] changeListToArray(ArrayList<String> searchList) {
            String[] strings = new String[searchList.size()];
            for (int i = 0; i < searchList.size(); i++) {
                strings[i] = searchList.get(i);
            }
            return strings;
    }
}
