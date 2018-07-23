package com.lgs.study.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgs.study.R;
import com.lgs.study.activity.ReadActivity;
import com.lgs.study.bean.TocListBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/1/001.
 */

public class TocListAdapter extends BaseQuickAdapter<TocListBean.PartListBean,BaseViewHolder> {
    public TocListAdapter(int layoutResId, @Nullable List<TocListBean.PartListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TocListBean.PartListBean item) {
        helper.setText(R.id.story_name, item.getPartTitle());
    }
}
