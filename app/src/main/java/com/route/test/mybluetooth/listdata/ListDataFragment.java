package com.route.test.mybluetooth.listdata;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.route.test.mybluetooth.R;
import com.route.test.mybluetooth.entity.SplendBean;
import com.route.test.mybluetooth.model.net.HttpUtils;
import com.route.test.mybluetooth.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1
 */
public class ListDataFragment extends Fragment {

    private RecyclerView recycler;
    private View view;
    private List<SplendBean.VideoBean> beanList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listdata, null);
        initView();
        initData();
        return view;
    }

    private void initView() {
        recycler = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);
    }

    private void initData() {
        boolean b = NetworkUtils.networkIsAvailable(getContext());
      //  Log.e("TAG", "有无网络 " + b);
        getDataFromNet();
    }
    private void getDataFromNet() {
        final ProgressDialog mDialog = new ProgressDialog(getContext());
        mDialog.show();
        HttpUtils.getPandaData(getContext()).getPandaData("VSET100167216881",
                "7", "panda", "desc", "time", "1")
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(new Action0() {
            @Override
            public void call() {
                mDialog.show();
            }
        }).subscribeOn(AndroidSchedulers.mainThread())
          .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<SplendBean>() {
            @Override
            public void onCompleted() {
                if (mDialog != null){
                    mDialog.cancel();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d("ListDataFragment", e.getMessage());
            }

            @Override
            public void onNext(SplendBean splendBean) {
                beanList.addAll(splendBean.getVideo());
                SplendAdapter splendAdapter = new SplendAdapter(getContext(),beanList);
                recycler.setAdapter(splendAdapter);
            }
        });
    }
}
