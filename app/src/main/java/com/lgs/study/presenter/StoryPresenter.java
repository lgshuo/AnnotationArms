package com.lgs.study.presenter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lgs.study.base.RxPresenter;
import com.lgs.study.bean.BannerBean;
import com.lgs.study.cons.Url;
import com.lgs.study.fragment.StoryFragment;
import com.lgs.study.model.RetrofitHelper;
import com.lgs.study.utils.ImageUtils;
import com.lgs.study.view.SuperRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by admin on 2018/4/28.
 */

public class StoryPresenter extends RxPresenter {
    @Inject
    public StoryPresenter(RetrofitHelper httpHelper) {
        super(httpHelper);
    }

    /**
     * banner
     */
    public void requestBanner() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("adNumber", "ad0201");
        loadNetData(Url.banner, hashMap);
    }

    public void doForBannerSuccess(String s, Banner banner) {
        ArrayList<String> imgs = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();
        Gson gson = new Gson();
        BannerBean bannerBean = gson.fromJson(s, BannerBean.class);
        List<BannerBean.AdListBean> adList = bannerBean.getAdList();
        for (BannerBean.AdListBean adListBean : adList) {
            imgs.add(adListBean.getAdImg().getImgSrc());
            title.add(adListBean.getAdTitle());
        }
        banner.setImages(imgs)
                .setBannerTitles(title)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setBannerAnimation(Transformer.Tablet)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        ImageUtils.loadImage(context, path.toString(), imageView);
                    }
                }).start();
    }

    public void requestStoryList() {
        HashMap<String, String> params = new HashMap<>();
        params.put("nowpage", "1");
        loadNetData(Url.storyList, params);
    }
    public void requestLoadMore(String page){
        HashMap<String, String> params = new HashMap<>();
        params.put("nowpage", page);
        loadNetData(Url.storyList,params,0,false);
    }
}
