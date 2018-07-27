package com.lgs.study.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lgs.study.R;
import com.lgs.study.activity.BookStoreActivity;
import com.lgs.study.adapter.StudyAdapter;
import com.lgs.study.base.BaseFragment;
import com.lgs.study.bean.StudyBean;
import com.lgs.study.wan_android.IndexActivity;
import com.lscs.lgs.annotationlib.annotation.ContentView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by admin on 2018/4/27.
 */
@ContentView(R.layout.fragment_person)
public class PersonFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private ArrayList<StudyBean> mList = new ArrayList<>();
    private StudyAdapter mAdapter;

    public void initData() {
        mList.add(new StudyBean(R.drawable.ic_booksvg, "书籍"));
        mList.add(new StudyBean(R.drawable.ic_net, "网络"));
        mList.add(new StudyBean(R.drawable.ic_note, "笔记"));
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mAdapter = new StudyAdapter(R.layout.item_study, mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void initEvent() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:

//                        startActivity(new Intent(getActivity(),BookStoreActivity.class));
                        break;
                    case 1:
                        IndexActivity.actionStart(getActivity());
                        break;
                    case 2:

                        break;
                }
            }
        });
    }
}
