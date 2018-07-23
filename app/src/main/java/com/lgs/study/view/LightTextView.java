package com.lgs.study.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lgs.study.R;

/**
 * Created by Administrator on 2018/4/24/024.
 */

public class LightTextView extends android.support.v7.widget.AppCompatTextView {
    public LightTextView(Context context) {
        this(context,null);
    }

    public LightTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LightTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        Paint paint = getPaint();
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.LightTextView);
        String filter = attributes.getString(R.styleable.LightTextView_filter);
        BlurMaskFilter.Blur type = BlurMaskFilter.Blur.NORMAL;
        BlurMaskFilter maskFilter = new BlurMaskFilter(10f, type);
        paint.setMaskFilter(maskFilter);
        paint.setStrokeWidth(10f);
        switch (filter) {
            case "outer":
                type = BlurMaskFilter.Blur.OUTER;
                maskFilter=new  BlurMaskFilter(20f, type);
                paint.setMaskFilter(maskFilter);
                paint.setStrokeWidth(80f);
                paint.setColor(Color.WHITE);
                break;
            case "inner":
                type = BlurMaskFilter.Blur.INNER;
                maskFilter=new  BlurMaskFilter(10f, type);
                paint.setMaskFilter(maskFilter);
                break;
            case "solid":
                type = BlurMaskFilter.Blur.SOLID;
                maskFilter=new  BlurMaskFilter(10f, type);
                paint.setMaskFilter(maskFilter);
                break;
            case "emboss":
                float[] direction = new float[]{1f, 1f, 1f};
                EmbossMaskFilter embossMaskFilter = new EmbossMaskFilter(direction, 0.5f, 1f, 1f);
                paint.setMaskFilter(embossMaskFilter);
                break;
        }


    }
}
