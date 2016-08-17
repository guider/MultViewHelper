package com.yanyuanquan.android.multviewhelper.explan;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;

import com.yanyuanquan.android.multviewhelper.MultViewHelper;
import com.yanyuanquan.android.multviewhelper.R;

/**
 * Created by apple on 16/8/16.
 */

public class SinaMultViewHelper extends MultViewHelper {

    public SinaMultViewHelper(Fragment fragment, View contentView) {
        super(fragment, contentView);
    }

    public SinaMultViewHelper(Fragment fragment, int contentViewId) {
        super(fragment, contentViewId);
    }

    public SinaMultViewHelper(android.support.v4.app.Fragment fragment, View contentView) {
        super(fragment, contentView);
    }

    public SinaMultViewHelper(android.support.v4.app.Fragment fragment, int contentViewId) {
        super(fragment, contentViewId);
    }

    public SinaMultViewHelper(Activity activity, FrameLayout parentView, View contentView) {
        super(activity, parentView, contentView);
    }

    public SinaMultViewHelper(Activity activity, FrameLayout parentView, int contentViewId) {
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
