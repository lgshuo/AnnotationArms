package com.lgs.study.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lgs.study.R;
import com.lgs.study.adapter.TocListAdapter;
import com.lgs.study.base.BaseHttpActivity;
import com.lgs.study.bean.TocListBean;
import com.lgs.study.cons.Url;
import com.lgs.study.presenter.TocListPresenter;
import com.lscs.lgs.annotationlib.annotation.ContentView;
import com.lscs.lgs.annotationlib.annotation.onSuccess;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/1/001.
 */
@ContentView(R.layout.activity_toclist)
public class TocListActivity extends BaseHttpActivity<TocListPresenter> {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private List<TocListBean.PartListBean> mList = new ArrayList<>();
    private TocListAdapter mAdapter;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    public void initData() {
        mImmersionBar.transparentStatusBar()
                .init();
        String book_id = getIntent().getStringExtra("book_id");
        mPresenter.requestTocList(book_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TocListAdapter(R.layout.item_activity_toclist, mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void initEvent(){
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.actionStart(TocListActivity.this,mList.get(position).getDownUrl());
            }
        });
    }

    @onSuccess(url = Url.book_title)
    public void requestTocListSuccess(String s){
        mList.clear();
        Gson gson = new Gson();
        TocListBean tocListBean = gson.fromJson(s, TocListBean.class);
        mList.addAll(tocListBean.getPartList());
        mAdapter.notifyDataSetChanged();
    }

    public static void actionStart(Activity activity, String bookId) {
        Intent intent = new Intent(activity, TocListActivity.class);
        intent.putExtra("book_id", bookId);
        activity.startActivity(intent);
    }
}
