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

    // hide MultView   and the MultView will not be generate
    boolean isNeedMultView() default true;

    int loadingTextId() default 0;

    int emptyTextId() default 0;

    int errorTextId() default 0;
}
