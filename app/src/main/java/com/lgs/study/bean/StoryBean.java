package com.lgs.study.bean;

import java.util.List;

/**
 * Created by admin on 2018/4/28.
 */

public class StoryBean {

    /**
     * booklist : [{"BookId":254,"BookType":0,"BookName":"2018年2月上半月","BookAbout":"开卷故事\t2\r\n笑话15则\t旗艺果 等  4\r\n新传说 \r\n好个\u201c低头族\u201d\t张晶晶  8\r\n\u201c认输\u201d的警官\t时海潮 17\r\n瞧这老哥俩\t任黎明 20\r\n第三不幸\t高国俊 24\r\n葫芦缘\t韩  冬 28\r\n网文热读\r\n失手\t张佳竹 11\r\n诙段子\t15\r\n外国文学故事鉴赏\r\n三狂人\t33\r\n情节聚焦\r\n以毒攻毒\t杨功战 37\r\n情感故事\r\n我是你弟弟吗\t童树梅 39\r\n东方夜谈\r\n不下跪的人\t大刀红","BookImg":"http://storyimg.storychina.cn//uploads/20180130/201801301014359273245.jpg","BookReader":26,"BookScore":0,"BookWriter":null,"BookSizeWords":0,"BookMoneyAll":0,"BookMoneyMin":0,"BookOver":0,"BookDateUp":"2018-01-30","BookTerm":"2018年2月上","userFav":0,"userUp":0,"userBuy":0},{"BookId":253,"BookType":0,"BookName":"《故事会文摘版》2018年1月","BookAbout":"《故事会文摘版》2018年1月","BookImg":"http://storyimg.storychina.cn//uploads/20180119/201801191115299071490.jpg","BookReader":26,"BookScore":0,"BookWriter":null,"BookSizeWords":0,"BookMoneyAll":0,"BookMoneyMin":0,"BookOver":0,"BookDateUp":"2018-01-19","BookTerm":"2018年1月","userFav":0,"userUp":0,"userBuy":0},{"BookId":252,"BookType":0,"BookName":"2018年1月下半月","BookAbout":"开卷故事\t\r\n2／爱的承诺\t刘雁君\r\n笑话\t\r\n4／《财政大权》等14则\t潘光贤等\r\n新传说\r\n8／比酒定亲\t顾敬堂\r\n17／坑神\t叶凌云\r\n20／咸鱼翻身\t滕建军\r\n23／值钱的\u201c宝贝\u201d\t潘李君\r\n34／暖心扶贫\t荻  秋\r\n38／不该抓的坏人\t贺小波\r\n42／网红本色\t水  沐\r\n外国文学故事鉴赏\r\n11／绝妙的晚餐\t\r\n诙段子\r\n15／《微笑之言》等\r\n传闻轶事\r\n26／温泡菜\t河西走狼\r\n","BookImg":"http://storyimg.storychina.cn//uploads/20180115/201801151116173723283.jpg","BookReader":40,"BookScore":0,"BookWriter":null,"BookSizeWords":0,"BookMoneyAll":0,"BookMoneyMin":0,"BookOver":0,"BookDateUp":"2018-01-15","BookTerm":"2018年1月下","userFav":0,"userUp":0,"userBuy":0},{"BookId":251,"BookType":0,"BookName":"2018年1月上半月","BookAbout":"开卷故事\r\n2／小推理，大智慧\t吕?佳\r\n笑   话\r\n4／《抽奖》等15则\t彼得等\r\n新传说\r\n8／鼻子靠墙\t王长军\r\n17／要命的麻将牌\t时海潮\r\n20／状元房\t任黎明\r\n24／爱不失聪\t蒋诗经\r\n27／海鲜不能和维C同吃\t陈  颖\r\n东方夜谈\r\n11／宋朝穿越记\t李生才\r\n情节聚焦\r\n15／我要见义勇为了\t张  宇\r\n网文热读\r\n31／佛跳墙\t张佳竹\r\n34／三易婚期\t江志强\r\n传闻轶事\r\n","BookImg":"http://storyimg.storychina.cn//uploads/20171228/201712281112185275015.jpg","BookReader":97,"BookScore":0,"BookWriter":null,"BookSizeWords":0,"BookMoneyAll":0,"BookMoneyMin":0,"BookOver":0,"BookDateUp":"2017-12-28","BookTerm":"2018年1月上","userFav":0,"userUp":0,"userBuy":0}]
     * errcode : 0
     * errmsg : 执行成功
     * countNum : 76
     * maxPage : 19
     */

    private int errcode;
    private String errmsg;
    private int countNum;
    private int maxPage;
    private List<BooklistBean> booklist;

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

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public List<BooklistBean> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<BooklistBean> booklist) {
        this.booklist = booklist;
    }

    public static class BooklistBean {
        /**
         * BookId : 254
         * BookType : 0
         * BookName : 2018年2月上半月
         * BookAbout : 开卷故事	2
         笑话15则	旗艺果 等  4
         新传说
         好个“低头族”	张晶晶  8
         “认输”的警官	时海潮 17
         瞧这老哥俩	任黎明 20
         第三不幸	高国俊 24
         葫芦缘	韩  冬 28
         网文热读
         失手	张佳竹 11
         诙段子	15
         外国文学故事鉴赏
         三狂人	33
         情节聚焦
         以毒攻毒	杨功战 37
         情感故事
         我是你弟弟吗	童树梅 39
         东方夜谈
         不下跪的人	大刀红
         * BookImg : http://storyimg.storychina.cn//uploads/20180130/201801301014359273245.jpg
         * BookReader : 26
         * BookScore : 0
         * BookWriter : null
         * BookSizeWords : 0
         * BookMoneyAll : 0
         * BookMoneyMin : 0
         * BookOver : 0
         * BookDateUp : 2018-01-30
         * BookTerm : 2018年2月上
         * userFav : 0
         * userUp : 0
         * userBuy : 0
         */

        private int BookId;
        private int BookType;
        private String BookName;
        private String BookAbout;
        private String BookImg;
        private int BookReader;
        private int BookScore;
        private Object BookWriter;
        private int BookSizeWords;
        private int BookMoneyAll;
        private int BookMoneyMin;
        private int BookOver;
        private String BookDateUp;
        private String BookTerm;
        private int userFav;
        private int userUp;
        private int userBuy;

        public int getBookId() {
            return BookId;
        }

        public void setBookId(int BookId) {
            this.BookId = BookId;
        }

        public int getBookType() {
            return BookType;
        }

        public void setBookType(int BookType) {
            this.BookType = BookType;
        }

        public String getBookName() {
            return BookName;
        }

        public void setBookName(String BookName) {
            this.BookName = BookName;
        }

        public String getBookAbout() {
            return BookAbout;
        }

        public void setBookAbout(String BookAbout) {
            this.BookAbout = BookAbout;
        }

        public String getBookImg() {
            return BookImg;
        }

        public void setBookImg(String BookImg) {
            this.BookImg = BookImg;
        }

        public int getBookReader() {
            return BookReader;
        }

        public void setBookReader(int BookReader) {
            this.BookReader = BookReader;
        }

        public int getBookScore() {
            return BookScore;
        }

        public void setBookScore(int BookScore) {
            this.BookScore = BookScore;
        }

        public Object getBookWriter() {
            return BookWriter;
        }

        public void setBookWriter(Object BookWriter) {
            this.BookWriter = BookWriter;
        }

        public int getBookSizeWords() {
            return BookSizeWords;
        }

        public void setBookSizeWords(int BookSizeWords) {
            this.BookSizeWords = BookSizeWords;
        }

        public int getBookMoneyAll() {
            return BookMoneyAll;
        }

        public void setBookMoneyAll(int BookMoneyAll) {
            this.BookMoneyAll = BookMoneyAll;
        }

        public int getBookMoneyMin() {
            return BookMoneyMin;
        }

        public void setBookMoneyMin(int BookMoneyMin) {
            this.BookMoneyMin = BookMoneyMin;
        }

        public int getBookOver() {
            return BookOver;
        }

        public void setBookOver(int BookOver) {
            this.BookOver = BookOver;
        }

        public String getBookDateUp() {
            return BookDateUp;
        }

        public void setBookDateUp(String BookDateUp) {
            this.BookDateUp = BookDateUp;
        }

        public String getBookTerm() {
            return BookTerm;
        }

        public void setBookTerm(String BookTerm) {
            this.BookTerm = BookTerm;
        }

        public int getUserFav() {
            return userFav;
        }

        public void setUserFav(int userFav) {
            this.userFav = userFav;
        }

        public int getUserUp() {
            return userUp;
        }

        public void setUserUp(int userUp) {
            this.userUp = userUp;
        }

        public int getUserBuy() {
            return userBuy;
        }

        public void setUserBuy(int userBuy) {
            this.userBuy = userBuy;
        }
    }
}
