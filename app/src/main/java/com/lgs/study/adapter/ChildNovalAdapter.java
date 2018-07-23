package com.lgs.study.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgs.study.R;
import com.lgs.study.bean.NovalBean;
import com.lgs.study.utils.ImageUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/4/28/028.
 */

public class ChildNovalAdapter extends BaseQuickAdapter<NovalBean.NovelListBean.BookListBean,BaseViewHolder> {
    public ChildNovalAdapter(int layoutResId, @Nullable List<NovalBean.NovelListBean.BookListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NovalBean.NovelListBean.BookListBean item) {
        helper.setText(R.id.child_name, item.getBookName());
        ImageUtils.loadImage(mContext,item.getBookImg(), (ImageView) helper.getView(R.id.child_face));
    }
}
