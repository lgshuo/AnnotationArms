package com.lgs.study.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgs.study.R;
import com.lgs.study.bean.StoryBean;
import com.lgs.study.utils.ImageUtils;

import java.util.List;

/**
 * Created by admin on 2018/4/28.
 */

public class StoryAdapter extends BaseQuickAdapter<StoryBean.BooklistBean, BaseViewHolder> {
    public StoryAdapter(int layoutResId, @Nullable List<StoryBean.BooklistBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StoryBean.BooklistBean item) {
        ImageUtils.loadImage(mContext, item.getBookImg(), (ImageView) helper.getView(R.id.face));
        helper.setText(R.id.book_name, item.getBookName())
                .setText(R.id.time, item.getBookDateUp())
                .setText(R.id.have_read, "已有"+item.getBookReader()+"人阅读")
                .setText(R.id.content, item.getBookAbout());
    }
}
