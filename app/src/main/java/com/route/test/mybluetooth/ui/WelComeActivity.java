package com.route.test.mybluetooth.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.route.test.mybluetooth.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelComeActivity extends AppCompatActivity {

    @Bind(R.id.splash_img)
    ImageView splashImg;
    private SharedPreferences shared;
    private SharedPreferences.Editor editor;
    public Runnable runnable=new Runnable(){
        @Override
        public void run() {
            if(shared.getBoolean("boo",true)){
                Intent in=new Intent(WelComeActivity.this,SplashActivity.class);
                startActivity(in);
                editor.putBoolean("boo",false);
                editor.commit();
                finish();
            }else {
                Intent intent=new Intent(WelComeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
        ButterKnife.bind(this);
        shared = getSharedPreferences("data", MODE_PRIVATE);
        editor = shared.edit();
        Handler handler=new Handler();
        handler.postDelayed(runnable,2000);
    }
}
