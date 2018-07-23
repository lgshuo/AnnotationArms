package com.lgs.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.activity.LoginActivity;
import com.lgs.study.activity.SearchActivity;
import com.lgs.study.annotations.socpe.initData;
import com.lgs.study.annotations.socpe.initEvent;
import com.lgs.study.base.BaseActivity;
import com.lgs.study.presenter.MainPresenter;
import com.lgs.study.utils.AppManager;
import com.lgs.study.utils.FragNavController;
import com.lgs.study.utils.ShowUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.float_action_bar)
    FloatingActionButton mSearchView;

    private FragNavController fragNavController;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private MainPresenter mPresenter;


    @initData
    public void initData() {
        mPresenter = new MainPresenter(this);
        mPresenter.requestPermission();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        if (mNavigationView != null) {
            setupDrawerContent(mNavigationView);
        }
        mPresenter.bindBottomBarData(fragmentList);
        fragNavController = new FragNavController(null        //用来管理底部按钮的工具类
                , getSupportFragmentManager()
                , R.id.fl_content
                , fragmentList
                , FragNavController.TAB1);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @initEvent
    public void initEvent() {
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                int color = 0;
                int colorInt = 0;
                int id = 0;
                switch (tabId) {
                    case R.id.tab_home:
                        color = R.color.statusbarColor;
                        colorInt = R.drawable.selector_status;
                        mToolbar.setTitle(getString(R.string.story));
                        id = 0;
                        break;
                    case R.id.tab_noval:
                        color = R.color.colorRed;
                        colorInt = R.drawable.selector_red;
                        mToolbar.setTitle(getString(R.string.noval));
                        id = 1;
                        break;
                    case R.id.tab_person:
                        color = R.color.colorPerson;
                        colorInt = R.drawable.selector_person;
                        mToolbar.setTitle(getString(R.string.study));
                        id = 2;
                        break;
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mNavigationView.setItemTextColor(getResources().getColorStateList(colorInt, null));
                    mNavigationView.setItemIconTintList(getResources().getColorStateList(colorInt, null));
                    mSearchView.setBackgroundTintList(getResources().getColorStateList(color, null));
                }
                fragNavController.switchTab(id);
                mImmersionBar
                        .statusBarColor(color)
                        .navigationBarColor(color)
                        .addViewSupportTransformColor(mToolbar)  //设置支持view变色，可以添加多个view，不指定颜色，默认和状态栏同色，还有两个重载方法
                        .addViewSupportTransformColor(mNavigationView.getHeaderView(0))  //设置支持view变色，可以添加多个view，不指定颜色，默认和状态栏同色，还有两个重载方法
                        .titleBar(R.id.toolbar)
                        .init();
            }
        });
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_collection:       //收藏
                                menuItem.setChecked(true);
                                break;
                            case R.id.nav_category:         //关于我们
                                menuItem.setChecked(true);
                                break;
                            case R.id.nav_subscribe:        //随便逛逛
                                menuItem.setChecked(true);
                                break;
                            case R.id.help:                 //帮助

                                break;
                            case R.id.setting:              //设置

                                break;
                            case R.id.rechage:              //充值
                                ShowUtils.showSnackBar(MainActivity.this, "等待开发中");
                                break;
                        }
                        return true;
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_login) {
            LoginActivity.actionStart(this);
            return true;
        } else if (id == R.id.action_search) {
            SearchActivity.actionStart(this,mSearchView,R.color.colorAccent);
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 双击退出
     */
    private long firstTime = 0;

    @Override
    public void onBackPressed() {
        long secoundTime = System.currentTimeMillis();
        if (secoundTime - firstTime > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = secoundTime;
        } else {
            AppManager.exitApp();
        }
    }

    public static void actionStart(Activity context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    @OnClick(R.id.float_action_bar)
    public void onViewClicked() {
        SearchActivity.actionStart(this,mSearchView,R.color.colorAccent);
    }
}

