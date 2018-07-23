package com.lgs.study.presenter;

import com.lgs.study.base.RxPresenter;
import com.lgs.study.cons.Url;
import com.lgs.study.model.RetrofitHelper;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/4/30/030.
 */

public class SearchResultPresenter extends RxPresenter {
    @Inject
    public SearchResultPresenter(RetrofitHelper httpHelper) {
        super(httpHelper);
    }

    public void requestSeachContent(String searchContent,String searchType) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bookType", "0");
        hashMap.put("searchType", searchType);
        hashMap.put("searchKeys", searchContent);
        hashMap.put("nowpage", "1");
        loadNetData(Url.searchStory,hashMap);
    }

    public void requestLoadMore(String searchContent, String nowPage,String searchType) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bookType", "0");
        hashMap.put("searchType", searchType);
        hashMap.put("searchKeys", searchContent);
        hashMap.put("nowpage", nowPage);
        loadNetData(Url.searchStory,hashMap,0,false);
    }
}
