package com.lgs.study.bean;

/**
 * Created by Administrator on 2018/5/3/003.
 */

public class StudyBean {
    private int drawableId;
    private String name;

    public StudyBean(int drawableId, String name) {
        this.drawableId = drawableId;
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
