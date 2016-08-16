package com.yanyuanquan.android.multviewhelpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.yanyuanquan.android.multviewhelper.inter.MultViewHelperInter;
import com.yanyuanquan.android.multviewhelper.explan.DefaultMultVIewHelp;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected MultViewHelperInter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = getHelper();

        ButterKnife.bind(this);

        findViewById(R.id.loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.showLoadingView();
            }
        });
        findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.showErrorView();
            }
        });
        findViewById(R.id.empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.showEmptyView();
            }
        });

        findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.showContentView();
            }
        });

        findViewById(R.id.def).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaseActivity.this, DefaultActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.v4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaseActivity.this, V4Activity.class);
                startActivity(intent);
            }
        });

    }


    public MultViewHelperInter getHelper() {
        if (helper == null) {
            View view = LayoutInflater.from(this).inflate(getLayouId(), null);
            helper = new DefaultMultVIewHelp(this, (FrameLayout) findViewById(R.id.container), view);
        }
        return helper;
    }

    public abstract int getLayouId();


}
