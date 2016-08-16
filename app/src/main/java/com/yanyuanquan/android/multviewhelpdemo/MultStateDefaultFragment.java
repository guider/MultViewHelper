package com.yanyuanquan.android.multviewhelpdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanyuanquan.android.multviewhelper.MultViewHelper;
import com.yanyuanquan.android.multviewhelper.MultViewHelperInter;
import com.yanyuanquan.android.multviewhelper.explan.DefaultMultVIewHelp;

/**
 * Created by apple on 16/8/16.
 */

public class MultStateDefaultFragment extends Fragment {
    MultViewHelperInter helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (helper = new DefaultMultVIewHelp(this, getLayout())).getFragmentView();
    }

    public int getLayout() {
        return R.layout.fragment_default;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        helper.showContentView();
        getView().findViewById(R.id.loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.showLoadingView();
            }
        });
        getView().findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.showErrorView();
            }
        });
        getView().findViewById(R.id.empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.showEmptyView();
            }
        });
        getView().findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.showContentView();
            }
        });

    }

    public void onBack() {
        helper.showContentView();
    }
}
