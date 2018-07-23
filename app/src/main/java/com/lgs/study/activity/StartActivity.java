package com.lgs.study.activity;

import android.widget.ImageView;
import com.lgs.study.MainActivity;
import com.lgs.study.R;
import com.lgs.study.annotations.socpe.initData;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.base.BaseActivity;
import com.lgs.study.base.IView;
import com.lgs.study.bean.StartBean;
import com.lgs.study.presenter.StartPresenter;
import com.lgs.study.utils.RxBus;
import com.lgs.study.view.CompletedView;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * Created by admin on 2018/2/10.
 */
@ContentView(R.layout.activity_start)
public class StartActivity extends BaseActivity implements IView {
    @BindView(R.id.start_bg)
    ImageView mStartBg;
    @BindView(R.id.cv)
    CompletedView mCompletedView;
    public StartPresenter mStartPresenter;


    @initData
    public void initData() {
        mStartPresenter = new StartPresenter();
        mStartPresenter.attachView(this);
        mStartPresenter.startAnim(mStartBg);
        RxBus.getDefault().toDefaultFlowable(StartBean.class, new Consumer<StartBean>() {
            @Override
            public void accept(StartBean startBean) throws Exception {
                mCompletedView.setProgress(startBean.getProgress());
            }
        });
    }
    @OnClick(R.id.cv)
    public void onViewClicked() {
        LoginActivity.actionStart(StartActivity.this);
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStartPresenter.detachView();
    }
}
