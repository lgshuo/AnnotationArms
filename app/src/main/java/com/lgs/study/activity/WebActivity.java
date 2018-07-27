package com.lgs.study.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.lgs.study.R;
import com.lgs.study.base.BaseActivity;
import com.lscs.lgs.annotationlib.annotation.ContentView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/1/001.
 */
@ContentView(R.layout.activity_web)
public class WebActivity extends BaseActivity {
    @BindView(R.id.web_view)
    WebView mWebView;

    public void initData() {
        mImmersionBar.transparentStatusBar().init();
        String link = getIntent().getStringExtra("link");
        WebSettings ws = mWebView.getSettings();
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);// 排版适应屏幕
        ws.setUseWideViewPort(true);// 可任意比例缩放
        ws.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webView推荐使用的窗口。setLoadWithOverviewMode方法是设置webView加载的页面的模式。
        ws.setSaveFormData(true);// 保存表单数据
        ws.setJavaScriptEnabled(true);
        ws.setTextZoom(400);
        ws.setDefaultTextEncodingName("gbk") ;
        mWebView.setBackgroundColor(Color.TRANSPARENT); // 设置背景色
        ws.setDomStorageEnabled(true);
        ws.setSupportMultipleWindows(true);// 新加
        // mWebView.addJavascriptInterface(new JsInterface(), "ssss");
        mWebView.setVisibility(View.VISIBLE);
        mWebView.loadUrl(link);
    }
    public static  void actionStart(Activity activity,String link){
        Intent intent = new Intent(activity, WebActivity.class);
        intent.putExtra("link", link);
        activity.startActivity(intent);
    }
}
