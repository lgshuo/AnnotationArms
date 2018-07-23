package com.lgs.study.activity;

import android.animation.Animator;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lgs.study.MainActivity;
import com.lgs.study.R;
import com.lgs.study.adapter.NovalTypeAdapter;
import com.lgs.study.annotations.socpe.initData;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.annotations.socpe.initEvent;
import com.lgs.study.annotations.socpe.onSuccess;
import com.lgs.study.base.BaseHttpActivity;
import com.lgs.study.bean.NovalTypeBean;
import com.lgs.study.cons.Url;
import com.lgs.study.globe.App;
import com.lgs.study.presenter.SearchPresenter;
import com.lgs.study.utils.ACache;
import com.lgs.study.utils.CircularAnim;
import com.lgs.study.utils.ShowUtils;

import java.util.ArrayList;
import java.util.HashSet;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/29/029.
 */
@ContentView(R.layout.activity_search)
public class SearchActivity extends BaseHttpActivity<SearchPresenter> {
    @BindView(R.id.search_content)
    AutoCompleteTextView mSearchContent;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private ArrayList<NovalTypeBean.TypeListBean> mList = new ArrayList<>();
    private ACache mACache;
    private ArrayList<String> mSearchList = new ArrayList<>();
    private NovalTypeAdapter mAdapter;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @initData
    public void initData() {
        mImmersionBar
                .titleBar(R.id.parent_search)
                .init();
        mACache = ACache.get(this);
        Object search = mACache.getAsObject("search");
        if (search!=null) {
            mSearchList.addAll((ArrayList) search);
            String[] array = mPresenter.changeListToArray(mSearchList);
            mSearchContent.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array ));
        }
        mPresenter.requestForSearchRecommend();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new NovalTypeAdapter(R.layout.item_activity_noval_type, mList);
        mRecyclerView.setAdapter(mAdapter);
    }
    @initEvent
    public void initEvent(){
        mSearchContent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                trySearch();
                return true;
            }
        });
    }

    @OnClick(R.id.search_button)
    public void onViewClicked() {
        trySearch();
    }

    /**
     * 搜索
     */
    private void trySearch() {
        String searchContent = mSearchContent.getText().toString().trim();
        if (TextUtils.isEmpty(searchContent)) {
            ShowUtils.showSnackBar(this, "请输入搜索内容");
            return;
        } else {
            if (!mSearchList.contains(searchContent)) {
                mSearchList.add(searchContent);
                mACache.put("search", mSearchList);
            }
            SearchResultActivity.actionStart(this,searchContent,"1");
        }
    }


    @onSuccess(url = Url.novalType)
    public void requestNovalTypeSuccess(String  s){
        Gson gson = new Gson();
        NovalTypeBean novalTypeBean = gson.fromJson(s, NovalTypeBean.class);
        mList.clear();
        mList.addAll(novalTypeBean.getTypeList());
        mAdapter.notifyDataSetChanged();
    }


    public static void actionStart(final Activity activity, final View view,int color) {
        CircularAnim.fullActivity(activity, view)
                .colorOrImageRes(color)
                .go(new CircularAnim.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd() {
                        Intent intent = new Intent(activity, SearchActivity.class);
                        activity.startActivity(intent);
                    }
                });

    }
}
