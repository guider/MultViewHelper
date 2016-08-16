package com.yanyuanquan.android.multviewhelpdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

/**
 * Created by apple on 16/8/16.
 */

public class DefaultActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        final Fragment fragment = new MultStateDefaultFragment();
        ft.add(R.id.container, fragment);
        ft.show(fragment);
        ft.commit();

        findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MultStateDefaultFragment) fragment).onBack();
            }
        });
    }
}
