package com.lgs.study.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lgs.study.R;
import com.lgs.study.adapter.StoryAdapter;
import com.lgs.study.annotations.socpe.initData;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.annotations.socpe.initEvent;
import com.lgs.study.annotations.socpe.onError;
import com.lgs.study.annotations.socpe.onSuccess;
import com.lgs.study.base.BaseHttpActivity;
import com.lgs.study.bean.StoryBean;
import com.lgs.study.cons.Url;
import com.lgs.study.presenter.SearchResultPresenter;
import com.lgs.study.view.SuperRecyclerView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/30/030.
 */
@ContentView(R.layout.activity_search_result)
public class SearchResultActivity extends BaseHttpActivity<SearchResultPresenter> {
    @BindView(R.id.super_recycler_view)
    SuperRecyclerView mSuperRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private int nowPage = 1;
    private List<StoryBean.BooklistBean> mSearchResultList = new ArrayList<>();
    private StoryAdapter mAdapter;
    private String mSearchContent;
    private String mSearchType;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @initData
    public void initData() {
        mImmersionBar
                .titleBar(R.id.toolbar)
                .init();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.back);

        mSuperRecyclerView.getRefreshView().setPrimaryColors(0xff01a6ff);
        mSearchContent = getIntent().getStringExtra("searchContent");
        mSearchType = getIntent().getStringExtra("searchType");
        mAdapter = new StoryAdapter(R.layout.item_fragment_story, mSearchResultList);
        mSuperRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSuperRecyclerView.setAdapter(mAdapter);
        mSuperRecyclerView.setRefreshing();
    }

    @initEvent
    public void initEvent() {
        mSuperRecyclerView.setOnRefreshListerner(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mSuperRecyclerView.loadMoreEnable(true);
                mPresenter.requestSeachContent(mSearchContent, mSearchType);
            }
        });
        mSuperRecyclerView.setOnLoadMoreListerner(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.requestLoadMore(mSearchContent, ++nowPage + "", mSearchType);
            }
        });
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TocListActivity.actionStart(SearchResultActivity.this,mSearchResultList.get(position).getBookId()+"");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @onSuccess(url = Url.searchStory)
    public void requestSearchSuccess(String s) {
        Gson gson = new Gson();
        StoryBean storyBean = gson.fromJson(s, StoryBean.class);
        if (nowPage == 1) {
            mSearchResultList.clear();
        }
        mSearchResultList.addAll(storyBean.getBooklist());
        mAdapter.notifyDataSetChanged();
        if (nowPage > storyBean.getMaxPage()) {
            mSuperRecyclerView.loadMoreEnable(false);
        }
        mSuperRecyclerView.finishLoading();
    }

    @onError(url = Url.searchStory)
    public void requestSearchFaild(String s) {
        mSuperRecyclerView.loadMoreEnable(false);
        mSuperRecyclerView.finishLoading();
    }

    public static void actionStart(Activity activity, String searchContent, String searchType) {
        Intent intent = new Intent(activity, SearchResultActivity.class);
        intent.putExtra("searchContent", searchContent);
        intent.putExtra("searchType", searchType);
        activity.startActivity(intent);
    }
}
