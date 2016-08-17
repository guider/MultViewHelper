package com.yanyuanquan.android.multviewhelpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.yanyuanquan.android.multviewhelper.inter.MultViewHelperInter;
import com.yanyuanquan.android.multviewhelper.explan.DefaultMultVIewHelper;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected MultViewHelperInter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = getHelper();

    }


    public MultViewHelperInter getHelper() {
        if (helper == null) {
            View view = LayoutInflater.from(this).inflate(getLayouId(), null);
            helper = new DefaultMultVIewHelper(this, (FrameLayout) findViewById(R.id.container), view);
        }
        return helper;
    }

    public abstract int getLayouId();


}
