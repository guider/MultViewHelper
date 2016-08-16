package com.yanyuanquan.android.multviewhelper.anno;


import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewHelp {

    int loadingViewId() default 0;

    int emptyViewId() default 0;

    int errorViewId() default 0;


    boolean isNeedMultView() default true;

    int emptyTextId() default 0;

    int errorTextId() default 0;
}
