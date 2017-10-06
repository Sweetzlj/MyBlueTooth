package com.route.test.mybluetooth.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.route.test.mybluetooth.R;
import com.route.test.mybluetooth.adapter.TabPagerAdapter;
import com.route.test.mybluetooth.listdata.ListDataFragment;
import com.route.test.mybluetooth.xueya.XueYaFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.vp)
    ViewPager vp;
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list.add(new ListDataFragment());
        list.add(new XueYaFragment());
        vp.setAdapter(new TabPagerAdapter(getSupportFragmentManager(),list));
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setupWithViewPager(vp);
    }
}

