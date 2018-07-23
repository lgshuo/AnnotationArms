package com.lgs.study.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
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

public class NovalTypeChildAdapter  extends BaseQuickAdapter<NovalTypeBean.TypeListBean.NovelClassBean,BaseViewHolder>{
    public NovalTypeChildAdapter(int layoutResId, @Nullable List<NovalTypeBean.TypeListBean.NovelClassBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final NovalTypeBean.TypeListBean.NovelClassBean item) {
        helper.setText(R.id.child_name, item.getNovelTitle());
        helper.setOnClickListener(R.id.child_name, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchResultActivity.actionStart((Activity) mContext, item.getNovelTitle(), "2");
            }
        });
    }
}
