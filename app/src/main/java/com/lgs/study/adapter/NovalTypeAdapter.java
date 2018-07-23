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
import com.lgs.study.bean.NovalTypeBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/30/030.
 */

public class NovalTypeAdapter extends BaseQuickAdapter<NovalTypeBean.TypeListBean, BaseViewHolder> {
    public NovalTypeAdapter(int layoutResId, @Nullable List<NovalTypeBean.TypeListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final NovalTypeBean.TypeListBean item) {
        helper.setText(R.id.child_title, item.getNovelType());
        RecyclerView recycler = helper.getView(R.id.child_recycler);
        NovalTypeChildAdapter childAdapter = new NovalTypeChildAdapter(R.layout.item_child_noval_type, item.getNovelClass());

        recycler.setLayoutManager(new GridLayoutManager(mContext,3));
        recycler.setAdapter(childAdapter);
    }
}
