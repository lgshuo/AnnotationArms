package com.lscs.lgs.annotationlib.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by JokAr on 16/8/6.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface onSuccess {
    String url();
    int type() default 0;
}
