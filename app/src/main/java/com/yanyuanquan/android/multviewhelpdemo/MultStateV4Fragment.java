package com.yanyuanquan.android.multviewhelpdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanyuanquan.android.multviewhelper.inter.MultViewHelperInter;
import com.yanyuanquan.android.multviewhelper.explan.DefaultMultVIewHelper;

import butterknife.ButterKnife;

/**
 * Created by apple on 16/8/16.
 */

public class MultStateV4Fragment extends Fragment {

    MultViewHelperInter helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        ButterKnife.bind(this, view);
        return (helper = new DefaultMultVIewHelper(this, view)).getFragmentView();
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
