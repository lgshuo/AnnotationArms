package com.lgs.study.activity;

import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.arialyy.annotations.DownloadGroup;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadGroupTask;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lgs.study.R;
import com.lgs.study.adapter.BookStoreAdapter;
import com.lgs.study.annotations.socpe.initData;
import com.lgs.study.annotations.socpe.ContentView;
import com.lgs.study.annotations.socpe.initEvent;
import com.lgs.study.base.BaseActivity;
import com.lgs.study.base.IView;
import com.lgs.study.bean.BookLinkBean;
import com.lgs.study.presenter.BookStorePresneter;
import com.lgs.study.utils.SPUtils;
import com.lgs.study.utils.ShowUtils;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/5/3/003.
 */
@ContentView(R.layout.activity_bookstore)
public class BookStoreActivity extends BaseActivity implements IView {
    public ArrayList<BookLinkBean> mList = new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private boolean isDownload = false;
    private int nowPosition = 0;
    private BookStorePresneter mPresenter;
    private BookStoreAdapter mAdapter;


    @initData
    public void initData() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new BookStoreAdapter(R.layout.item_activity_book_store, mList);
        mRecyclerView.setAdapter(mAdapter);
        mImmersionBar.transparentStatusBar().init();
        mPresenter = new BookStorePresneter();
        mPresenter.attachView(this);
        mPresenter.initBookStore(mList);
        mAdapter.notifyDataSetChanged();
        Aria.download(this).register();

    }

    @initEvent
    public void initEvent() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ArrayList names = mPresenter.getNames(mList.get(position).getList());
                boolean had = (Boolean) SPUtils.get("a_" + position, false);
                if (had) {
//                    PdfActivity.actionStart(BookStoreActivity.this, Environment.getExternalStorageDirectory().getPath() + "/Download/a_" + position + "a_" + position + ".pdf");
                } else {
                    if (!isDownload) {
                        Aria.download(BookStoreActivity.this)
                                .load(mList.get(position).getList())
                                .setDownloadDirPath(
                                        Environment.getExternalStorageDirectory().getPath() + "/Download/a_" + position)
                                .setGroupAlias("a_" + position)
                                .setSubFileName(names)
                                //.setFileSize(32895492)
                                .start();
                        isDownload = true;
                    } else {
                        ShowUtils.showToast("当前已有任务在下载");
                    }
                }
            }
        });
    }

    @DownloadGroup.onTaskRunning()
    protected void running(DownloadGroupTask task) {
//        mList.get(nowPosition).setProcess(task.getPercent());
//        mAdapter.notifyDataSetChanged();
    }

    @DownloadGroup.onTaskComplete()
    void taskComplete(DownloadGroupTask task) {
        isDownload = false;
        SPUtils.put("a_" + nowPosition, true);
//        PdfActivity.actionStart(BookStoreActivity.this, Environment.getExternalStorageDirectory().getPath() + "/Download/a_" + nowPosition + "a_" + nowPosition + ".pdf");

    }

    @DownloadGroup.onTaskStart()
    void taskStart(DownloadGroupTask task) {
        isDownload = true;
    }
    @DownloadGroup.onTaskResume() void taskResume(DownloadGroupTask task) {
    }

    @DownloadGroup.onTaskStop() void taskStop(DownloadGroupTask task) {
    }

    @DownloadGroup.onTaskCancel()
    void taskCancel(DownloadGroupTask task) {
        isDownload = false;
    }

    @DownloadGroup.onTaskFail()
    void taskFail(DownloadGroupTask task) {
        isDownload = false;
    }

}
