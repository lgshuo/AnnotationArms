package com.lgs.study.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/7/007.
 */

public class BookLinkBean {
    private String name;
    private ArrayList<String> mList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getList() {
        return mList;
    }

    public void setList(ArrayList list) {
        mList = list;
    }

    public BookLinkBean(String name, ArrayList list) {
        this.name = name;
        mList = list;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    private int process;

    public BookLinkBean addLink(String link) {
        synchronized (BookLinkBean.class) {
            if (mList==null) {
                mList = new ArrayList<>();
            }
        }
        mList.add(link);
        return this;
    }
}
