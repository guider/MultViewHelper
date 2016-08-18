package com.yanyuanquan.android.multviewhelpdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayouId() {
        return R.layout.activity_mian_content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this,helper.getContentView());
        helper.showContentView();
    }

    @OnClick({R.id.lv_act, R.id.static_act, R.id.web_act, R.id.lv_fragment, R.id.static_fragment, R.id.web_fragment})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.lv_act:
                break;
            case R.id.static_act:
                break;
            case R.id.web_act:
                break;
            case R.id.lv_fragment:
                break;
            case R.id.static_fragment:
                break;
            case R.id.web_fragment:
                break;
        }
    }

}
