package com.yanyuanquan.android.multviewhelper;


import android.view.View;

public interface MultViewHelperInter {

    View getFragmentView();

    void showLoadingView();

    void showErrorView();

    void showEmptyView();

    void showContentView();

    int getLoadingViewId();

    int getErrorViewId();

    int getEmptyViewId();


    View getLoadingView();

    View getErrorView();

    View getEmptyView();

    View getContentView();

    int getLoadingTextId();

    int getErrorTextId();

    int getEmptyTextId();

}
