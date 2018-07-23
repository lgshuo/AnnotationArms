package com.lgs.study.wan_android;

import android.app.Activity;
import android.content.Intent;

import com.lgs.study.R;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.base.BaseActivity;

/**
 * Created by Administrator on 2018/7/23 0023.
 */
@ContentView(R.layout.activity_index)
public class IndexActivity extends BaseActivity {


    public static void actionStart(Activity activity){
        Intent intent = new Intent(activity, IndexActivity.class);
        activity.startActivity(intent);
    }
}
