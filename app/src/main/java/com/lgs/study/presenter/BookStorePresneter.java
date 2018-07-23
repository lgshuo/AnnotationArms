package com.lgs.study.presenter;

import com.lgs.study.activity.BookStoreActivity;
import com.lgs.study.base.BasePresenter;
import com.lgs.study.base.IView;
import com.lgs.study.bean.BookLinkBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/7/007.
 */

public class BookStorePresneter implements BasePresenter {
    private BookStoreActivity mView;
    @Override
    public void attachView(IView view) {
        mView = (BookStoreActivity) view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public void initBookStore(ArrayList<BookLinkBean> list) {


        list.add(new BookLinkBean("第一行代码 Android 第2版", new ArrayList()).addLink("https://gitee.com/linguangshuo/resources/raw/master/a_1.pdf"));
        list.add(new BookLinkBean("Android群英传",new ArrayList()).addLink("https://gitee.com/linguangshuo/resources/raw/master/a_2.pdf-0.dat")
                .addLink("https://gitee.com/linguangshuo/resources/raw/master/a_2.pdf-1.dat")
        );
        list.add(new BookLinkBean("疯狂Android讲义", new ArrayList()).addLink("https://gitee.com/linguangshuo/resources/raw/master/a_3.pdf-0.dat")
                .addLink("https://gitee.com/linguangshuo/resources/raw/master/a_3.pdf-1.dat")
                .addLink("https://gitee.com/linguangshuo/resources/raw/master/a_3.pdf-2.dat")
                .addLink("https://gitee.com/linguangshuo/resources/raw/master/a_3.pdf-3.dat")
        );

        list.add(new BookLinkBean("Android软件安全与逆向分析", new ArrayList()).addLink("https://gitee.com/linguangshuo/resources/raw/master/a_4.pdf"));

        list.add(new BookLinkBean("Android编程经典200例", new ArrayList()).addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_5.pdf-0.dat")
                .addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_5.pdf-1.dat"));

        list.add(new BookLinkBean("Android经典项目案例开发实战宝典", new ArrayList()).addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_6.pdf-0.dat")
                .addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_6.pdf-1.dat")
                .addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_6.pdf-2.dat")
                .addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_6.pdf-3.dat")
        );

        list.add(new BookLinkBean("Android开发艺术探索", new ArrayList()).addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_7.pdf-0.dat")
                .addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_7.pdf-1.dat")
                .addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_7.pdf-2.dat")
        );
        list.add(new BookLinkBean("ANDROID可穿戴设备高级编程", new ArrayList()).addLink("https://gitee.com/linguangshuo/resources/raw/master/a_8.pdf"));
        list.add(new BookLinkBean("Android应用开发揭秘", new ArrayList()).addLink("https://gitee.com/linguangshuo/resources/raw/master/a_9.pdf"));
        list.add(new BookLinkBean("ANDROID游戏开发大全", new ArrayList()).addLink("https://gitee.com/linguangshuo/resources/raw/master/a_10.pdf"));

        list.add(new BookLinkBean("Android源码设计模式解析与实战", new ArrayList()).addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_11.pdf-0.dat")
                .addLink("https://gitee.com/linguangshuo/resource_2/raw/master/a_11.pdf-1.dat")
        );
    }

    public ArrayList<String> getNames(ArrayList<String> list) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).split("raw/master/")[1];
            names.add(name);
        }
        return names;
    }
}
