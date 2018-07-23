package com.lgs.study.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.lgs.study.R;

/**
 * Created by lin on 2017/3/21.
 * 操作图片的工具类
 */

public class ImageUtils {
    public static void loadCircleImage(Context context, String url, ImageView imageView) {
        Glide.with(context) // 指定Context
                .load(url)// 指定图片的URL
                .error(R.drawable.img_error).placeholder(R.drawable.img_load).centerCrop().transform(new GlideCircleTransform(context)).into(imageView);//指定显示图片的ImageView
    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context) // 指定Context
                .load(url)// 指定图片的URL
                .error(R.drawable.img_error).placeholder(R.drawable.img_load).fitCenter().into(imageView);//指定显示图片的ImageView
    }
}
