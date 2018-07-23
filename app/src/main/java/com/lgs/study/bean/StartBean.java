package com.lgs.study.bean;

/**
 * Created by admin on 2018/4/26.
 */

public class StartBean {
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    private int progress;
    public StartBean(int i) {
        progress = i;
    }
}
