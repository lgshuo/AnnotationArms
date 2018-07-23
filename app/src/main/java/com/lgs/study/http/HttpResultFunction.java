package com.lgs.study.http;


import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * http结果处理函数
 *
 * @author ZhongDaFeng
 */

public class HttpResultFunction implements Function<Throwable, Flowable<ResponseBody>> {
    @Override
    public Flowable<ResponseBody> apply(@NonNull Throwable throwable) throws Exception {
        //打印具体错误
        return Flowable.error(ExceptionEngine.handleException(throwable));
    }
}
