package com.lscs.lgs.annotationlib.model;


import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;

/**
 * Created by JokAr on 16/8/8.
 */
public class onFaild {
    private ExecutableElement mExecutableElement;

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    private String urlType;
    private Name mMethodName;

    public onFaild(Element element) throws IllegalArgumentException {
        if (element.getKind() != ElementKind.METHOD) {
            throw new IllegalArgumentException(
                    String.format("Only methods can be annotated with @%s",
                            com.lscs.lgs.annotationlib.annotation.onFaild .class.getSimpleName()));
        }

        mExecutableElement = (ExecutableElement) element;

        urlType =mExecutableElement.getAnnotation(com.lscs.lgs.annotationlib.annotation.onFaild.class).type()+ mExecutableElement.getAnnotation(com.lscs.lgs.annotationlib.annotation.onFaild.class).url();

        mMethodName = mExecutableElement.getSimpleName();
/*        List<? extends VariableElement> parameters = mExecutableElement.getParameters();

        if (parameters.size() > 0) {
            throw new IllegalArgumentException(
                    String.format("The method annotated with @%s must have no parameters",
                            com.annotation.onFaild.class.getSimpleName()));
        }*/
    }

    /**
     * 获取方法名称
     * @return
     */
    public Name getMethodName() {
        return mMethodName;
    }
}
