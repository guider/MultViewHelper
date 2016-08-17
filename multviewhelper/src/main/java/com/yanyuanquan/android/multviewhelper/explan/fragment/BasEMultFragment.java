package com.yanyuanquan.android.multviewhelper.explan.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanyuanquan.android.multviewhelper.explan.DefaultMultVIewHelper;
import com.yanyuanquan.android.multviewhelper.inter.MultViewHelperInter;

/**
 * Created by apple on 16/8/16.
 */

public abstract class BaseMultFragment extends Fragment {

    MultViewHelperInter helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        helper = new DefaultMultVIewHelper(this, inflater.inflate(getLayoutId(), null));
        initView(helper.getContentView());
        return helper.getFragmentView();
    }

    public void initView(View contentView) {

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initData();

    }

    public abstract void initData();


    public abstract void init();


    public abstract int getLayoutId();


}
