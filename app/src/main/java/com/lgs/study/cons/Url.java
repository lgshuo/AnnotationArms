package com.lgs.study.cons;

/**
 * Created by admin on 2018/4/24.
 */

public interface Url {
    String banner = "http://storyapi.storychina.cn/Ad/AdGet.ashx";
    String login = "http://storyuapi.storychina.cn/usaccount/AccountLogin.ashx";
    String getConfirm = "http://storyuapi.storychina.cn/usaccount/SendPhoneCode.ashx";
    String forgetPwd = "http://storyuapi.storychina.cn/usaccount/ResetPassWord.ashx";
    String regist = "http://storyuapi.storychina.cn/usaccount/AccountReg.ashx";
    String storyList = "http://storyapi.storychina.cn/StoryBook/GetMagazine.ashx";
    String recommend = "http://storyapi.storychina.cn/StoryBook/GetNovel.ashx";

    String novalType = "http://storyapi.storychina.cn/StoryBook/GetNovelType.ashx";         //小说分类列表
    String searchStory = "http://storyapi.storychina.cn/StoryBook/GetBookSearch.ashx";      //      bookType=0&searchType=1&searchKeys=故事会&nowpage=1    搜索
    String book_title = "http://storyapi.storychina.cn/StoryBook/GetBookParts.ashx";

    String storyInfo = "http://storyapi.storychina.cn/StoryBook/GetBookInfo.ashx?timekey=1525056366000&uid=undefined&accesstoken=NjYwMDB1bmRlZmluZWQ1MjUwNTYzNg%3D%3D&userNumber=&BookId=247";
    //storyInforbean
    String bbsList = "http://storyapi.storychina.cn/BBSService/GetBBSList.ashx?timekey=1525056527000&uid=undefined&accesstoken=MjcwMDB1bmRlZmluZWQ1MjUwNTY1Mg%3D%3D&userNumber=&bbsType=1&bbsPara=262&nowpage=1";
    //bbsbean

    //发送评论
    String sendBBS = "http://storyapi.storychina.cn/BBSService/BbsSend.ashx?timekey=1525056925000&uid=108628&accesstoken=MjUwMDAxMDg2Mjg1MjUwNTY5Mg%3D%3D";
    String txt= "http://storyimg.storychina.cn//BookTextList/20180330/201803301023204859.txt";
//            userNumber=108628&bbsType=1&bbsPara=262&bbsBody=%E8%93%9D%E8%89%B2%E7%9A%84%E6%B2%A1%E6%9C%89%E7%AC%91%E8%AF%9D%E7%9A%84
}

