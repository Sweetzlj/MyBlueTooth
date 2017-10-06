package com.route.test.mybluetooth.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.route.test.mybluetooth.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.rollvp)
    ViewPager rollvp;
    @Bind(R.id.tv_jump)
    Button jump;
    private int recLen = 4;
    private ImageView[] dots;   //创建指示点集合
    private int[] ids = {R.id.iv_bit1, R.id.iv_bit2, R.id.iv_bit3};   //初始化指示点集合
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (recLen >= 1) {
                recLen--;
                jump.setText("跳过" + recLen);
                handler.postDelayed(this, 1000);
            } else {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }
    };
    private ArrayList<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        View view1 = LayoutInflater.from(this).inflate(R.layout.one, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.two, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.three, null);
        View jinru = view3.findViewById(R.id.jinru);
        jinru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

        list.add(view1);
        list.add(view2);
        list.add(view3);

        MyAdapter adapter = new MyAdapter(this, list);
        rollvp.setAdapter(adapter);

        initDots();
        rollvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < ids.length; i++) {
                    if (position == i) {
                        dots[i].setImageResource(R.drawable.circle_select);
                    } else {
                        dots[i].setImageResource(R.drawable.circle_normal);
                    }

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        jump.setOnClickListener(this);

      //   handler.postDelayed(runnable, 1000);
    }
    private void initDots() {
        dots = new ImageView[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dots[i] = (ImageView) findViewById(ids[i]);
            //根据当前页面的views.size()来变化指示图标
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_jump:
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    public class MyAdapter extends PagerAdapter {
        private Context context;
        private ArrayList<View> view;

        public MyAdapter(Context context, ArrayList<View> view) {
            this.context = context;
            this.view = view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(view.get(position), 0);
            return view.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(view.get(position));
        }

        @Override
        public int getCount() {
            return view.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
