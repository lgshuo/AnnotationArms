package com.lgs.study.presenter;

import android.Manifest;
import android.support.v4.app.Fragment;

import com.lgs.study.MainActivity;
import com.lgs.study.fragment.NovalFragment;
import com.lgs.study.fragment.PersonFragment;
import com.lgs.study.fragment.StoryFragment;
import com.lgs.study.utils.FragNavController;
import com.lgs.study.utils.ShowUtils;
import com.lgs.study.utils.rxpermission.PermissionHelper;
import com.lgs.study.utils.rxpermission.RxPermissions;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/30/030.
 */

public class MainPresenter {
    private MainActivity activity;

    public MainPresenter(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void requestPermission() {
        PermissionHelper.requestForWriteEx(activity, new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                ShowUtils.showSnackBar(activity,s);
            }
        });
    }

    public void bindBottomBarData(List<Fragment> fragmentList) {
        fragmentList.add(new StoryFragment());
        fragmentList.add(new NovalFragment());
        fragmentList.add(new PersonFragment());
    }
}
