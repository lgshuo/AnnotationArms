package com.lgs.study.activity;

import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.lgs.study.R;
import com.lgs.study.annotations.socpe.initData;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.base.BaseHttpActivity;
import com.lgs.study.presenter.ReadPresenter;

import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/4/30/030.
 */
@ContentView(R.layout.activity_read)
public class ReadActivity extends BaseHttpActivity<ReadPresenter> {
    @BindView(R.id.ivBack)
    ImageView mIvBack;
    @BindView(R.id.flReadWidget)
    FrameLayout flReadWidget;
    @BindView(R.id.llBookReadTop)
    LinearLayout mLlBookReadTop;
    @BindView(R.id.tvBookReadMode)
    TextView mTvBookReadMode;
    @BindView(R.id.tvBookReadSettings)
    TextView mTvBookReadSettings;
    @BindView(R.id.tvBookReadDownload)
    TextView mTvBookReadDownload;
    @BindView(R.id.tvBookReadToc)
    TextView mTvBookReadToc;
    @BindView(R.id.llBookReadBottom)
    LinearLayout mLlBookReadBottom;
    @BindView(R.id.rlBookReadRoot)
    RelativeLayout mRlBookReadRoot;

    @BindView(R.id.rlReadAaSet)
    LinearLayout rlReadAaSet;
    @BindView(R.id.ivBrightnessMinus)
    ImageView ivBrightnessMinus;
    @BindView(R.id.seekbarLightness)
    SeekBar seekbarLightness;
    @BindView(R.id.ivBrightnessPlus)
    ImageView ivBrightnessPlus;
    @BindView(R.id.tvFontsizeMinus)
    TextView tvFontsizeMinus;
    @BindView(R.id.seekbarFontSize)
    SeekBar seekbarFontSize;
    @BindView(R.id.tvFontsizePlus)
    TextView tvFontsizePlus;

    @BindView(R.id.cbVolume)
    CheckBox cbVolume;
    @BindView(R.id.cbAutoBrightness)
    CheckBox cbAutoBrightness;
    @BindView(R.id.gvTheme)
    GridView gvTheme;



    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @initData
    public void initData() {
        mPresenter.loadNetData("http://storyimg.storychina.cn//BookTextList/20180330/201803301023204859.txt",new HashMap<String, String>());
    }


}
