package com.lgs.study.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/28/028.
 */

public class SearchBean {

    /**
     * userNumber :
     * bookType : 0
     * searchType : 1
     * searchKeys : 故事会
     * booklist : [{"BookId":262,"BookType":0,"BookName":"《故事会文摘版》2018年4月","BookAbout":"《故事会文摘版》2018年4月","BookImg":"http://storyimg.storychina.cn//uploads/20180420/201804201058276373680.jpg","BookReader":14,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":5,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2018-04-20","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":259,"BookType":0,"BookName":"《故事会文摘版》2018年3月","BookAbout":"《故事会文摘版》2018年3月","BookImg":"http://storyimg.storychina.cn//uploads/20180319/201803190250330499881.jpg","BookReader":24,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":5,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2018-03-19","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":256,"BookType":0,"BookName":"《故事会文摘版》2018年2月","BookAbout":"《故事会文摘版》2018年2月","BookImg":"http://storyimg.storychina.cn//uploads/20180213/201802131222382729260.jpg","BookReader":41,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":5,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2018-02-13","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":253,"BookType":0,"BookName":"《故事会文摘版》2018年1月","BookAbout":"《故事会文摘版》2018年1月","BookImg":"http://storyimg.storychina.cn//uploads/20180119/201801191115299071490.jpg","BookReader":48,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":4,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2018-01-19","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":250,"BookType":0,"BookName":"《故事会文摘版》2017年12月","BookAbout":"《故事会文摘版》2017年12月","BookImg":"http://storyimg.storychina.cn//uploads/20171220/201712201108153909163.jpg","BookReader":41,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":3,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2017-12-20","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":237,"BookType":0,"BookName":"5元精品\u2014\u2014捣蛋鬼故事会","BookAbout":"无数事实、经验和理性已经证明：好故事可以影响人的一生。而以我们之见，所谓好故事，在内容上讲述的应是做人与处世的道理，在形式上也应听得进、记得住、讲得出、传得开，而且不会因时代的变迁而失去她的本质特征和艺术光彩。","BookImg":"http://storyimg.storychina.cn//uploads/20171120/201711200240358654758.jpg","BookReader":3,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":3,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2017-11-20","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":235,"BookType":0,"BookName":"《故事会文摘版》2017年11月","BookAbout":"《故事会文摘版》2017年11月","BookImg":"http://storyimg.storychina.cn//uploads/20171120/201711200143152951287.jpg","BookReader":48,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":3,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2017-11-20","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":177,"BookType":0,"BookName":"《故事会文摘版》2017年10月","BookAbout":"《故事会文摘版》2017年10月","BookImg":"http://storyimg.storychina.cn//uploads/20171020/201710201056285207680.jpg","BookReader":45,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":3,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2017-10-20","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":129,"BookType":0,"BookName":"《故事会文摘版》2017年9月","BookAbout":"《故事会文摘版》2017年9月","BookImg":"http://storyimg.storychina.cn//uploads/20170920/201709201020495067739.jpg","BookReader":51,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":3,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2017-09-20","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0},{"BookId":128,"BookType":0,"BookName":"《故事会文摘版》2017年8月","BookAbout":"卷 首\r\n一只耳朵/贾永\t01\r\n焦  点\r\n阿妈拉巴的酥油灯/丹增\t04\r\n艳遇/裘山山\t07\r\n我在欧洲特种部队当教官/郭小俊\t09\r\n视  点\r\n豌豆漫画/豌豆\t12\r\n十万次相亲/水水\t81\r\n封底故事：《高宗大阅兵图》\t84\r\n泪  点\r\n三个早逝孩子教会我的事/\r\n[美国]玛琳娜·罗丽亚 王庄林译\t14\r\n泪  点\r\n什么最重要/雪小禅\t17\r\n我爱你，早已胜却一切人间美味/今我来思\t","BookImg":"http://storyimg.storychina.cn//uploads/20170919/201709190144477699814.jpg","BookReader":24,"BookScore":0,"BookWriter":"故事会编辑部","BookSizeWords":0,"BookMoneyAll":3,"BookMoneyMin":0,"BookOver":1,"BookDateUp":"2017-09-19","BookTerm":null,"userFav":0,"userUp":0,"userBuy":0}]
     * errcode : 0
     * errmsg : ok
     * countNum : 43
     * nowpage : 1
     * maxPage : 5
     */

    private String userNumber;
    private String bookType;
    private String searchType;
    private String searchKeys;
    private int errcode;
    private String errmsg;
    private int countNum;
    private int nowpage;
    private int maxPage;
    private List<BooklistBean> booklist;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchKeys() {
        return searchKeys;
    }

    public void setSearchKeys(String searchKeys) {
        this.searchKeys = searchKeys;
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
         * BookId : 262
         * BookType : 0
         * BookName : 《故事会文摘版》2018年4月
         * BookAbout : 《故事会文摘版》2018年4月
         * BookImg : http://storyimg.storychina.cn//uploads/20180420/201804201058276373680.jpg
         * BookReader : 14
         * BookScore : 0
         * BookWriter : 故事会编辑部
         * BookSizeWords : 0
         * BookMoneyAll : 5
         * BookMoneyMin : 0
         * BookOver : 1
         * BookDateUp : 2018-04-20
         * BookTerm : null
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
        private String BookWriter;
        private int BookSizeWords;
        private int BookMoneyAll;
        private int BookMoneyMin;
        private int BookOver;
        private String BookDateUp;
        private Object BookTerm;
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

        public String getBookWriter() {
            return BookWriter;
        }

        public void setBookWriter(String BookWriter) {
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

        public Object getBookTerm() {
            return BookTerm;
        }

        public void setBookTerm(Object BookTerm) {
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
