package com.lscs.lgs.annotationlib;

import com.squareup.javapoet.ClassName;

/**
 * Created by JokAr on 16/8/8.
 */
public class TypeUtil {
    public static final ClassName INJET = ClassName.get("com.lgs.study.utils", "Inject");
    public static final ClassName HASH_MAP = ClassName.get("java.util", "HashMap");
    public static final ClassName STRING = ClassName.get("java.lang", "String");
    public static final ClassName EXCEPTION = ClassName.get("java.lang", "Exception");
}
