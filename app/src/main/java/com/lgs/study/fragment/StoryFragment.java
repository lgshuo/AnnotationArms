package com.lgs.study.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lgs.study.R;
import com.lgs.study.activity.TocListActivity;
import com.lgs.study.adapter.StoryAdapter;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.annotations.socpe.initData;
import com.lgs.study.annotations.socpe.initEvent;
import com.lgs.study.annotations.socpe.onSuccess;
import com.lgs.study.base.BaseHttpFragment;
import com.lgs.study.bean.StoryBean;
import com.lgs.study.cons.Url;
import com.lgs.study.presenter.StoryPresenter;
import com.lgs.study.view.SuperRecyclerView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by admin on 2018/4/27.
 */
@ContentView(R.layout.fragment_story)
public class StoryFragment extends BaseHttpFragment<StoryPresenter> {

    @BindView(R.id.super_recycler_view)
    SuperRecyclerView mSuperRecyclerView;
    private Banner mBanner;
    private List<StoryBean.BooklistBean> mStoryList = new ArrayList<>();
    private StoryAdapter mAdapter;
    private int nowPage = 1;


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @initData
    public void initData() {
        mSuperRecyclerView.getRefreshView().setPrimaryColors(0xff01a6ff);
        View head = View.inflate(getActivity(), R.layout.fragment_story_head, null);
        mBanner = (Banner) head.findViewById(R.id.banner);
        mAdapter = new StoryAdapter(R.layout.item_fragment_story, mStoryList);
        mSuperRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSuperRecyclerView.setAdapter(mAdapter);
        mAdapter.addHeaderView(head);
        mSuperRecyclerView.setRefreshing();
        mPresenter.requestBanner();
    }

    @initEvent()
    public void initEvent() {
        mSuperRecyclerView.setOnRefreshListerner(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mSuperRecyclerView.loadMoreEnable(true);
                mStoryList.clear();
                nowPage = 1;
                mPresenter.requestStoryList();
            }
        });
        mSuperRecyclerView.setOnLoadMoreListerner(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.requestLoadMore(++nowPage+"");
            }
        });
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TocListActivity.actionStart(getActivity(),mStoryList.get(position).getBookId()+"");
            }
        });
    }

    @onSuccess(url = Url.banner)
    public void onRequestBannerSuccess(String s) {
        mPresenter.doForBannerSuccess(s, mBanner);
    }

    @onSuccess(url = Url.storyList)
    public void onRequestStoryListSuccess(String s) {
        Gson gson = new Gson();
        StoryBean storyBean = gson.fromJson(s, StoryBean.class);
        if (nowPage==1) {
            mStoryList.clear();
        }
        mStoryList.addAll(storyBean.getBooklist());
        mAdapter.notifyDataSetChanged();
        if (nowPage > storyBean.getMaxPage()) {
            mSuperRecyclerView.loadMoreEnable(false);
        }
        mSuperRecyclerView.finishLoading();
    }
}
