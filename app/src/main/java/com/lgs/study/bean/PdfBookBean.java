package com.lgs.study.bean;

/**
 * Created by Administrator on 2018/5/5/005.
 */

public class PdfBookBean {
    private String name;

    public PdfBookBean(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

}
