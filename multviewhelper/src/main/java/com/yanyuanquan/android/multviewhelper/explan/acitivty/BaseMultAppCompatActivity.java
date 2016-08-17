package com.yanyuanquan.android.multviewhelper.explan.acitivty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.yanyuanquan.android.multviewhelper.R;
import com.yanyuanquan.android.multviewhelper.explan.DefaultMultVIewHelper;
import com.yanyuanquan.android.multviewhelper.inter.MultViewHelperInter;

/**
 * Created by apple on 16/8/16.
 */

public abstract class BaseMultAppCompatActivity extends AppCompatActivity {

    public MultViewHelperInter helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContenView();
        setContentView(getBasicLayoutId());
        initLayout();
        init();
        initData();
        initView();
    }

    protected void initLayout() {
        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        helper = new DefaultMultVIewHelper(this, container, getLayoutId());

    }

    protected abstract void initView();

    protected abstract void initData();


    protected abstract void init();


    protected abstract void beforeSetContenView();

    protected abstract int getLayoutId();

    protected abstract int getBasicLayoutId();

    public MultViewHelperInter MultVIewHelper() {
        return helper;
    }
}
