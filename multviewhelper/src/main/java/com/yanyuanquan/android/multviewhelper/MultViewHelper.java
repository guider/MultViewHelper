package com.yanyuanquan.android.multviewhelper;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.yanyuanquan.android.multviewhelper.anno.ViewHelp;

/**
 * Created by apple on 16/8/15.
 */

public abstract class MultViewHelper implements MultViewHelperInter {
    private View mLoadingView;
    private View mErrorView;
    private View mEmptyView;
    private View mContentView;

    LayoutInflater inflater;
    private FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams
            (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private FrameLayout root;

    public MultViewHelper(android.app.Fragment fragment, int contentLayoutId) {
        inflater = LayoutInflater.from(fragment.getActivity());
        ViewHelp anno = fragment.getClass().getAnnotation(ViewHelp.class);
        root = new FrameLayout(fragment.getActivity());
        init(anno, fragment.getActivity(), contentLayoutId);
    }

    public MultViewHelper(Fragment fragment, int contentLayoutId) {
        inflater = LayoutInflater.from(fragment.getActivity());
        ViewHelp anno = fragment.getClass().getAnnotation(ViewHelp.class);
        root = new FrameLayout(fragment.getActivity());
        init(anno, fragment.getActivity(), contentLayoutId);
    }

    public MultViewHelper(Activity activity, FrameLayout parentView, int contentLayoutId) {
        inflater = LayoutInflater.from(activity);
        ViewHelp anno = activity.getClass().getAnnotation(ViewHelp.class);
        root = parentView;
        init(anno, activity, contentLayoutId);

    }

    private void init(ViewHelp anno, Context context, int contentLayoutId) {
        mContentView = inflater.inflate(contentLayoutId, null);
        if (anno != null && !anno.isNeedMultView()) {
            root.addView(mContentView, lp);
            return;
        }
        root.addView(mContentView, lp);
        root.addView(initErrorView(anno), lp);
        root.addView(initEmptyView(anno), lp);
        root.addView(initLoadingView(anno), lp);
        showLoadingView();
    }

    public View getFragmentView() {
        return root;
    }

    private View initLoadingView(ViewHelp anno) {
        if (anno != null && anno.loadingViewId() != 0) {
            mLoadingView = inflater.inflate(anno.loadingViewId(), null);
        } else {
            mLoadingView = inflater.inflate(getLoadingViewId(), null);
        }
        return mLoadingView;
    }


    private View initEmptyView(ViewHelp anno) {
        if (anno != null && anno.errorViewId() != 0) {
            mEmptyView = inflater.inflate(anno.emptyViewId(), null);
        } else {
            mEmptyView = inflater.inflate(getEmptyViewId(), null);
        }
        return mEmptyView;
    }

    private View initErrorView(ViewHelp anno) {
        if (anno != null && anno.errorViewId() != 0) {
            mErrorView = inflater.inflate(anno.errorViewId(), null);
        } else {
            mErrorView = inflater.inflate(getErrorViewId(), null);
        }
        return mErrorView;
    }

    public void showLoadingView() {
        showViewState(STATE_LOADING);
    }


    public void showErrorView() {
        showViewState(STATE_ERROR);

    }

    public void showEmptyView() {
        showViewState(STATE_EMPTY);
    }

    public void showContentView() {
        showViewState(STATE_CONTENT);
    }

    private static final int STATE_LOADING = 1;
    private static final int STATE_EMPTY = 2;
    private static final int STATE_ERROR = 3;
    private static final int STATE_CONTENT = 4;

    private void showViewState(int state) {
        if (mLoadingView != null && state == STATE_LOADING) {
            mLoadingView.setVisibility(View.VISIBLE);
        } else {
            mLoadingView.setVisibility(View.GONE);
        }
        if (mErrorView != null && state == STATE_ERROR) {
            mErrorView.setVisibility(View.VISIBLE);
        } else {
            mErrorView.setVisibility(View.GONE);
        }
        if (mEmptyView != null && state == STATE_EMPTY) {
            mEmptyView.setVisibility(View.VISIBLE);
        } else {
            mEmptyView.setVisibility(View.GONE);
        }
        if (mContentView != null && state == STATE_CONTENT) {
            mContentView.setVisibility(View.VISIBLE);
        } else {
            mContentView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getLoadingTextId() {
        return R.string.laoding;
    }

    @Override
    public int getErrorTextId() {
        return R.string.error;
    }

    @Override
    public int getEmptyTextId() {
        return R.string.empty;
    }

    @Override
    public View getContentView() {
        return mContentView;
    }

    @Override
    public View getEmptyView() {
        return mEmptyView;
    }

    @Override
    public View getErrorView() {
        return mErrorView;
    }

    @Override
    public View getLoadingView() {
        return mLoadingView;
    }
}
