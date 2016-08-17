package com.yanyuanquan.android.multviewhelper.explan;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;

import com.yanyuanquan.android.multviewhelper.MultViewHelper;
import com.yanyuanquan.android.multviewhelper.R;


public class DefaultMultVIewHelper extends MultViewHelper {

    public DefaultMultVIewHelper(Fragment fragment, View contentView) {
        super(fragment, contentView);
    }

    public DefaultMultVIewHelper(Fragment fragment, int contentViewId) {
        super(fragment, contentViewId);
    }

    public DefaultMultVIewHelper(android.support.v4.app.Fragment fragment, View contentView) {
        super(fragment, contentView);
    }

    public DefaultMultVIewHelper(android.support.v4.app.Fragment fragment, int contentViewId) {
        super(fragment, contentViewId);
    }

    public DefaultMultVIewHelper(Activity activity, FrameLayout parentView, View contentView) {
        super(activity, parentView, contentView);
    }

    public DefaultMultVIewHelper(Activity activity, FrameLayout parentView, int contentViewId) {
        super(activity, parentView, contentViewId);
    }

    @Override
    public int getLoadingViewId() {
        return R.layout.multviewhelp_default_loadingview;
    }

    @Override
    public int getErrorViewId() {
        return R.layout.multviewhelp_default_errorview;
    }

    @Override
    public int getEmptyViewId() {
        return R.layout.multviewhelp_default_emptyview;
    }


}
