package com.yanyuanquan.android.multviewhelpdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yanyuanquan.android.multviewhelper.inter.MultViewHelperInter;
import com.yanyuanquan.android.multviewhelper.explan.DefaultMultVIewHelper;
import com.yanyuanquan.android.multviewhelper.inter.RetryListener;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 16/8/16.
 */

public class MultStateDefaultFragment extends Fragment implements RetryListener, SwipeRefreshLayout.OnRefreshListener {
    MultViewHelperInter helper;
    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swiperefreshlayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        ButterKnife.bind(this, view);
        listview = (ListView) view.findViewById(R.id.listview);
        swiperefreshlayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        swiperefreshlayout.setOnRefreshListener(this);

        return (helper = new DefaultMultVIewHelper(this, view)).getFragmentView();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        helper.setOnRetryListener(this);
        getData();

    }
    final String[] arr = {"111", "222", "333", "444", "555","666","777"};

    private void getData() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                listview.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr));
                swiperefreshlayout.setRefreshing(false);
                if (new Random().nextInt(7) > 3) {
                    helper.showContentView();
                } else if (new Random().nextInt(8) > 3){
                    helper.showErrorView();
                }else {
                    helper.showEmptyView();
                }
            }
        }, 2000);
    }

    public int getLayout() {
        return R.layout.fragment_v4;
    }


    public void onBack() {
        helper.showContentView();
    }

    @Override
    public void onRetry(View view) {
        helper.showLoadingView();
        onRefresh();
    }

    @Override
    public void onRefresh() {
        getData();
    }
}
