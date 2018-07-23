package com.lgs.study.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgs.study.R;
import com.lgs.study.activity.SearchResultActivity;
import com.lgs.study.activity.TocListActivity;
import com.lgs.study.bean.NovalBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/28/028.
 */

public class NovalAdapter extends BaseQuickAdapter<NovalBean.NovelListBean,BaseViewHolder> {
    public NovalAdapter(int layoutResId, @Nullable List<NovalBean.NovelListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final NovalBean.NovelListBean item) {
        helper.setText(R.id.child_title, item.getListName());
        RecyclerView recyclerView = helper.getView(R.id.child_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        ChildNovalAdapter adapter = new ChildNovalAdapter(R.layout.item_child_noval, item.getBookList());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TocListActivity.actionStart((Activity) mContext,item.getBookList().get(position).getBookId()+"");
            }
        });
    }
}
