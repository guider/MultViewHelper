package com.yanyuanquan.android.multviewhelpdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by apple on 16/8/16.
 */

public class V4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        final Fragment fragment = new MultStateV4Fragment();
        ft.add(R.id.container, fragment);
        ft.show(fragment);
        ft.commit();

        findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MultStateV4Fragment) fragment).onBack();
            }
        });
    }
}
