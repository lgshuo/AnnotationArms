package com.lgs.study.base;

public interface BasePresenter{

    void attachView(IView view);

    void detachView();

}