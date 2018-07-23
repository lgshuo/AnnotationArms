package com.lgs.study.bean;

import java.util.List;

/**
 * Created by admin on 2018/4/28.
 */

public class BannerBean {

    /**
     * adNumber : ad0201
     * adList : [{"adId":2,"adType":1,"adTitle":"4月下","adContent":{"ContentType":3,"adUrl":null,"wordId":0,"BookId":261},"adImg":{"imgSrc":"http://storyimg.storychina.cn//uploads/20180413/201804131015187986736.jpg","imgWidth":720,"imgHeight":320}},{"adId":6,"adType":1,"adTitle":"关于故事会","adContent":{"ContentType":2,"adUrl":null,"wordId":2,"BookId":0},"adImg":{"imgSrc":"http://storyimg.storychina.cn//uploads/20170717/201707171132195513136.jpg","imgWidth":720,"imgHeight":320}}]
     * countNum : 2
     * errcode : 0
     * errmsg : 执行成功
     */

    private String adNumber;
    private int countNum;
    private int errcode;
    private String errmsg;
    private List<AdListBean> adList;

    public String getAdNumber() {
        return adNumber;
    }

    public void setAdNumber(String adNumber) {
        this.adNumber = adNumber;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

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

    public List<AdListBean> getAdList() {
        return adList;
    }

    public void setAdList(List<AdListBean> adList) {
        this.adList = adList;
    }

    public static class AdListBean {
        /**
         * adId : 2
         * adType : 1
         * adTitle : 4月下
         * adContent : {"ContentType":3,"adUrl":null,"wordId":0,"BookId":261}
         * adImg : {"imgSrc":"http://storyimg.storychina.cn//uploads/20180413/201804131015187986736.jpg","imgWidth":720,"imgHeight":320}
         */

        private int adId;
        private int adType;
        private String adTitle;
        private AdContentBean adContent;
        private AdImgBean adImg;

        public int getAdId() {
            return adId;
        }

        public void setAdId(int adId) {
            this.adId = adId;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public String getAdTitle() {
            return adTitle;
        }

        public void setAdTitle(String adTitle) {
            this.adTitle = adTitle;
        }

        public AdContentBean getAdContent() {
            return adContent;
        }

        public void setAdContent(AdContentBean adContent) {
            this.adContent = adContent;
        }

        public AdImgBean getAdImg() {
            return adImg;
        }

        public void setAdImg(AdImgBean adImg) {
            this.adImg = adImg;
        }

        public static class AdContentBean {
            /**
             * ContentType : 3
             * adUrl : null
             * wordId : 0
             * BookId : 261
             */

            private int ContentType;
            private Object adUrl;
            private int wordId;
            private int BookId;

            public int getContentType() {
                return ContentType;
            }

            public void setContentType(int ContentType) {
                this.ContentType = ContentType;
            }

            public Object getAdUrl() {
                return adUrl;
            }

            public void setAdUrl(Object adUrl) {
                this.adUrl = adUrl;
            }

            public int getWordId() {
                return wordId;
            }

            public void setWordId(int wordId) {
                this.wordId = wordId;
            }

            public int getBookId() {
                return BookId;
            }

            public void setBookId(int BookId) {
                this.BookId = BookId;
            }
        }

        public static class AdImgBean {
            /**
             * imgSrc : http://storyimg.storychina.cn//uploads/20180413/201804131015187986736.jpg
             * imgWidth : 720
             * imgHeight : 320
             */

            private String imgSrc;
            private int imgWidth;
            private int imgHeight;

            public String getImgSrc() {
                return imgSrc;
            }

            public void setImgSrc(String imgSrc) {
                this.imgSrc = imgSrc;
            }

            public int getImgWidth() {
                return imgWidth;
            }

            public void setImgWidth(int imgWidth) {
                this.imgWidth = imgWidth;
            }

            public int getImgHeight() {
                return imgHeight;
            }

            public void setImgHeight(int imgHeight) {
                this.imgHeight = imgHeight;
            }
        }
    }
}
