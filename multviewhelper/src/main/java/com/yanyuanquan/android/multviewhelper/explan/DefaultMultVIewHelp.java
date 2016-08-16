package com.yanyuanquan.android.multviewhelper.explan;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;

import com.yanyuanquan.android.multviewhelper.MultViewHelper;
import com.yanyuanquan.android.multviewhelper.R;


public class DefaultMultVIewHelp extends MultViewHelper {

    public DefaultMultVIewHelp(Fragment fragment, int contentLayoutId) {
        super(fragment, contentLayoutId);
    }

    public DefaultMultVIewHelp(android.support.v4.app.Fragment fragment, int contentLayoutId) {
        super(fragment, contentLayoutId);
    }

    public DefaultMultVIewHelp(Activity activity, FrameLayout parentView, int contentLayoutId) {
        super(activity, parentView, contentLayoutId);
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
