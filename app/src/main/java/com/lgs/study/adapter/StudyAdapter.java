package com.lgs.study.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgs.study.R;
import com.lgs.study.bean.StudyBean;
import com.lgs.study.utils.ImageUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3/003.
 */

public class StudyAdapter extends BaseQuickAdapter<StudyBean,BaseViewHolder> {
    public StudyAdapter(int layoutResId, @Nullable List<StudyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StudyBean item) {
        helper.setText(R.id.title, item.getName());
        ImageView icon = helper.getView(R.id.icon);
        icon.setImageResource(item.getDrawableId());
    }
}
