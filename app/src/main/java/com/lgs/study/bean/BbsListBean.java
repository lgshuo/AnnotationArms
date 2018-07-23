package com.lgs.study.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/30/030.
 */

public class BbsListBean {

    /**
     * bbslist : [{"bbsId":282,"userNumber":"108311","userLikename":"你好！","userImg":"","bbsTime":"5 天","bbsBody":"不完整吧！笑话呢？忽悠我呢？","bbsUp":0,"bbsUpState":false,"bbsBack":0}]
     * errcode : 0
     * errmsg : 执行成功
     * countNum : 1
     * nowpage : 1
     * maxpage : 1
     */

    private int errcode;
    private String errmsg;
    private int countNum;
    private int nowpage;
    private int maxpage;
    private List<BbslistBean> bbslist;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    public int getNowpage() {
        return nowpage;
    }

    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }

    public int getMaxpage() {
        return maxpage;
    }

    public void setMaxpage(int maxpage) {
        this.maxpage = maxpage;
    }

    public List<BbslistBean> getBbslist() {
        return bbslist;
    }

    public void setBbslist(List<BbslistBean> bbslist) {
        this.bbslist = bbslist;
    }

    public static class BbslistBean {
        /**
         * bbsId : 282
         * userNumber : 108311
         * userLikename : 你好！
         * userImg :
         * bbsTime : 5 天
         * bbsBody : 不完整吧！笑话呢？忽悠我呢？
         * bbsUp : 0
         * bbsUpState : false
         * bbsBack : 0
         */

        private int bbsId;
        private String userNumber;
        private String userLikename;
        private String userImg;
        private String bbsTime;
        private String bbsBody;
        private int bbsUp;
        private boolean bbsUpState;
        private int bbsBack;

        public int getBbsId() {
            return bbsId;
        }

        public void setBbsId(int bbsId) {
            this.bbsId = bbsId;
        }

        public String getUserNumber() {
            return userNumber;
        }

        public void setUserNumber(String userNumber) {
            this.userNumber = userNumber;
        }

        public String getUserLikename() {
            return userLikename;
        }

        public void setUserLikename(String userLikename) {
            this.userLikename = userLikename;
        }

        public String getUserImg() {
            return userImg;
        }

        public void setUserImg(String userImg) {
            this.userImg = userImg;
        }

        public String getBbsTime() {
            return bbsTime;
        }

        public void setBbsTime(String bbsTime) {
            this.bbsTime = bbsTime;
        }

        public String getBbsBody() {
            return bbsBody;
        }

        public void setBbsBody(String bbsBody) {
            this.bbsBody = bbsBody;
        }

        public int getBbsUp() {
            return bbsUp;
        }

        public void setBbsUp(int bbsUp) {
            this.bbsUp = bbsUp;
        }

        public boolean isBbsUpState() {
            return bbsUpState;
        }

        public void setBbsUpState(boolean bbsUpState) {
            this.bbsUpState = bbsUpState;
        }

        public int getBbsBack() {
            return bbsBack;
        }

        public void setBbsBack(int bbsBack) {
            this.bbsBack = bbsBack;
        }
    }
}
