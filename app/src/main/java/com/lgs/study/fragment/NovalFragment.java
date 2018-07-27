package com.lgs.study.fragment;

import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.lgs.study.R;
import com.lgs.study.adapter.NovalAdapter;
import com.lgs.study.base.BaseHttpFragment;
import com.lgs.study.bean.NovalBean;
import com.lgs.study.cons.Url;
import com.lgs.study.presenter.NovalPresenter;
import com.lgs.study.view.SuperRecyclerView;
import com.lscs.lgs.annotationlib.annotation.ContentView;
import com.lscs.lgs.annotationlib.annotation.onSuccess;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by admin on 2018/4/27.
 */
@ContentView(R.layout.fragment_noval)
public class NovalFragment extends BaseHttpFragment<NovalPresenter> {
    @BindView(R.id.recycler_view)
    SuperRecyclerView mRecyclerView;
    private List<NovalBean.NovelListBean> mList = new ArrayList<>();
    private NovalAdapter mAdapter;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    public void initData() {
        mRecyclerView.getRefreshView().setPrimaryColors(0xffd50f09);
        mAdapter = new NovalAdapter(R.layout.item_fragment_noval, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setRefreshing();
    }

    public void initEvent() {
        mRecyclerView.setOnRefreshListerner(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.requestRecommend();
            }
        });
    }

    @onSuccess(url = Url.recommend)
    public void requestRecommend(String s) {
        Gson gson = new Gson();
        NovalBean novalBean = gson.fromJson(s, NovalBean.class);
        mList.addAll(novalBean.getNovelList());
        mAdapter.notifyDataSetChanged();
        mRecyclerView.loadMoreEnable(false);
        mRecyclerView.finishLoading();
    }
}

