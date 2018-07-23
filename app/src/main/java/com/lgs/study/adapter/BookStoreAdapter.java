package com.lgs.study.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgs.study.R;
import com.lgs.study.bean.BookLinkBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/7/007.
 */

public class BookStoreAdapter extends BaseQuickAdapter<BookLinkBean,BaseViewHolder> {
    public BookStoreAdapter(int layoutResId, @Nullable List<BookLinkBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookLinkBean item) {
        helper.setText(R.id.book_name, item.getName());
    }
}
