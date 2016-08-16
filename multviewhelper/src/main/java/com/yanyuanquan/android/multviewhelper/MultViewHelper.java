package com.yanyuanquan.android.multviewhelper;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yanyuanquan.android.multviewhelper.anno.ViewHelp;
import com.yanyuanquan.android.multviewhelper.inter.MultViewHelperInter;
import com.yanyuanquan.android.multviewhelper.inter.RetryListener;

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

    public MultViewHelper(android.app.Fragment fragment, View contentView) {
        inflater = LayoutInflater.from(fragment.getActivity());
        ViewHelp anno = fragment.getClass().getAnnotation(ViewHelp.class);
        root = new FrameLayout(fragment.getActivity());
        init(anno, fragment.getActivity(), contentView);
    }

    public MultViewHelper(Fragment fragment, View contentView) {
        inflater = LayoutInflater.from(fragment.getActivity());
        ViewHelp anno = fragment.getClass().getAnnotation(ViewHelp.class);
        root = new FrameLayout(fragment.getActivity());
        init(anno, fragment.getActivity(), contentView);
    }

    public MultViewHelper(Activity activity, FrameLayout parentView, View contentView) {
        inflater = LayoutInflater.from(activity);
        ViewHelp anno = activity.getClass().getAnnotation(ViewHelp.class);
        root = parentView;
        init(anno, activity, contentView);

    }

    private void init(ViewHelp anno, Context context, View contentView) {
        mContentView = contentView;
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
        TextView loadingTextView = (TextView) mLoadingView.findViewById(R.id.loadingtext);
        if (loadingTextView != null) {
            //noinspection ResourceType
            loadingTextView.setText((anno != null && anno.loadingTextId() != 0) ? anno.loadingTextId() : getLoadingTextId());
        }
        return mLoadingView;
    }


    private View initEmptyView(ViewHelp anno) {
        if (anno != null && anno.errorViewId() != 0) {
            mEmptyView = inflater.inflate(anno.emptyViewId(), null);
        } else {
            mEmptyView = inflater.inflate(getEmptyViewId(), null);
        }

        TextView emptyTextView = (TextView) mEmptyView.findViewById(R.id.emptytext);
        if (emptyTextView != null) {
            //noinspection ResourceType
            emptyTextView.setText((anno != null && anno.emptyTextId() != 0) ? anno.emptyTextId() : getEmptyTextId());
        }
        return mEmptyView;
    }

    private View initErrorView(ViewHelp anno) {
        if (anno != null && anno.errorViewId() != 0) {
            mErrorView = inflater.inflate(anno.errorViewId(), null);
        } else {
            mErrorView = inflater.inflate(getErrorViewId(), null);
        }
        TextView errorTextView = (TextView) mErrorView.findViewById(R.id.errortext);
        if (errorTextView != null) {
            //noinspection ResourceType
            errorTextView.setText(((anno != null && anno.errorTextId() != 0) ? anno.errorTextId() : getErrorTextId()));
        }
        View retry = mErrorView.findViewById(R.id.retry);
        if (retry != null) {
            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onRetry(v);
                    }
                }
            });
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

    private RetryListener listener;

    public void setOnRetryListener(RetryListener listener) {
        this.listener = listener;
    }

}
