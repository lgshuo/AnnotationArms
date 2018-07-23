package com.lgs.study.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/28/028.
 */

public class NovalTypeBean {

    /**
     * typeList : [{"novelType":"都市","novelClass":[{"typeId":44,"novelTitle":"职场"},{"typeId":43,"novelTitle":"婚恋"},{"typeId":42,"novelTitle":"家园"}]},{"novelType":"言情","novelClass":[{"typeId":37,"novelTitle":"青春"},{"typeId":34,"novelTitle":"现言"},{"typeId":33,"novelTitle":"亲情"}]},{"novelType":"悬疑","novelClass":[{"typeId":50,"novelTitle":"探案"},{"typeId":49,"novelTitle":"推理"},{"typeId":48,"novelTitle":"恐怖"}]},{"novelType":"笑话","novelClass":[{"typeId":55,"novelTitle":"幽默"},{"typeId":54,"novelTitle":"滑稽"},{"typeId":29,"novelTitle":"喜剧"}]}]
     * errcode : 0
     * errmsg : ok
     */

    private int errcode;
    private String errmsg;
    private List<TypeListBean> typeList;

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

    public List<TypeListBean> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeListBean> typeList) {
        this.typeList = typeList;
    }

    public static class TypeListBean {
        /**
         * novelType : 都市
         * novelClass : [{"typeId":44,"novelTitle":"职场"},{"typeId":43,"novelTitle":"婚恋"},{"typeId":42,"novelTitle":"家园"}]
         */

        private String novelType;
        private List<NovelClassBean> novelClass;

        public String getNovelType() {
            return novelType;
        }

        public void setNovelType(String novelType) {
            this.novelType = novelType;
        }

        public List<NovelClassBean> getNovelClass() {
            return novelClass;
        }

        public void setNovelClass(List<NovelClassBean> novelClass) {
            this.novelClass = novelClass;
        }

        public static class NovelClassBean {
            /**
             * typeId : 44
             * novelTitle : 职场
             */

            private int typeId;
            private String novelTitle;

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public String getNovelTitle() {
                return novelTitle;
            }

            public void setNovelTitle(String novelTitle) {
                this.novelTitle = novelTitle;
            }
        }
    }
}
