package com.lscs.lgs.annotationlib.model;

import com.lscs.lgs.annotationlib.TypeUtil;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.util.ArrayList;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;


/**
 * Created by JokAr on 16/8/8.
 */
public class AnnotatedClass {

    private TypeElement mTypeElement;
    private ArrayList<onSuccess> mSuccessMethods;
    private ArrayList<onFaild> mFaildMethods;
    private Elements mElements;

    public AnnotatedClass(TypeElement typeElement, Elements elements) {
        mTypeElement = typeElement;
        mElements = elements;
        mSuccessMethods = new ArrayList<>();
        mFaildMethods = new ArrayList<>();
    }

    public void addSuccessMethod(onSuccess method) {
        mSuccessMethods.add(method);
    }
    public void addFaildMethod(onFaild method) {
        mFaildMethods.add(method);
    }

    public JavaFile generateFile() {
        MethodSpec.Builder cons = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC);
        cons.addStatement("    synchronized ($L$$$$ResultInject.class){\n" +
                "      if (successMap == null) {\n" +
                "        successMap = new HashMap();\n" +
                "      }\n" +
                "    };", mTypeElement.getSimpleName());


        cons.addStatement("    synchronized ($L$$$$ResultInject.class){\n" +
                "      if (faildMap == null) {\n" +
                "        faildMap = new HashMap();\n" +
                "      }\n" +
                "    };", mTypeElement.getSimpleName());

        for (onSuccess method : mSuccessMethods) {
            cons.addStatement("successMap.put($S,$S)", method.getUrlType(), method.getMethodName());
        }
        for (onFaild method : mFaildMethods) {
            cons.addStatement("faildMap.put($S,$S)", method.getUrlType(), method.getMethodName());
        }
//        for (onFaild method : mFaildMethods) {
//            cons.addStatement("map.put($S,$S)", method.getUrlType(), method.getMethodName());
//        }

        //generateMethod
        MethodSpec.Builder injectSucessMethod = MethodSpec.methodBuilder("injectSuccess")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mTypeElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeUtil.STRING, "url")
                .addParameter(TypeName.INT, "type")
                .addParameter(TypeUtil.STRING, "result", Modifier.FINAL)
                .addException(TypeUtil.EXCEPTION);

        MethodSpec.Builder injectFaildMethod = MethodSpec.methodBuilder("injectFaild")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mTypeElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeUtil.STRING, "url")
                .addParameter(TypeName.INT, "type")
                .addParameter(TypeUtil.STRING, "result", Modifier.FINAL)
                .addException(TypeUtil.EXCEPTION);


        injectSucessMethod.addStatement("String methodName = (String)successMap.get($L)", "type+url");
        injectSucessMethod.addStatement(" java.lang.reflect.Method method = host.getClass().getMethod($L,$L);\n" +
                "if (method != null && host != null) { \n" +
                "method.invoke(host, result);\n" +
                "}", "methodName","String.class");


        injectFaildMethod.addStatement("String methodName = (String)faildMap.get($L)", "type+url");
        injectFaildMethod.addStatement(" java.lang.reflect.Method method = host.getClass().getMethod($L,$L);\n" +
                "if (method != null && host != null) { \n" +
                "method.invoke(host, result);\n" +
                "}", "methodName","String.class");

        //generaClass
        TypeSpec injectClass = TypeSpec.classBuilder(mTypeElement.getSimpleName() + "$$ResultInject")
                .addModifiers(Modifier.PUBLIC)
                .addField(TypeUtil.HASH_MAP, "successMap")
                .addField(TypeUtil.HASH_MAP, "faildMap")
                .addSuperinterface(ParameterizedTypeName.get(TypeUtil.INJET, TypeName.get(mTypeElement.asType())))
                .addMethod(injectSucessMethod.build())
                .addMethod(injectFaildMethod.build())
                .addMethod(cons.build())
                .build();

        String packgeName = mElements.getPackageOf(mTypeElement).getQualifiedName().toString();

        return JavaFile.builder(packgeName, injectClass).build();
    }
}
