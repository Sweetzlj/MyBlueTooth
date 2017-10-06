package com.route.test.mybluetooth.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.route.test.mybluetooth.R;

/**
 * Created by my301s on 2017/9/4.
 */

public class MyZhu extends View{

    private Paint bPaint,sPaint,txtPaint;
    private float mWidth,mHeight,rectTop,rectTop2;
    String zhuTxt1 = "100";
    String zhuTxt2 = "100";

    public MyZhu(Context context) {
        super(context);
        initPaint();
    }

    public MyZhu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyZhu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint(){
        bPaint  = new Paint();
        bPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        bPaint.setStrokeWidth(50);
        bPaint.setStyle(Paint.Style.FILL);

        sPaint = new Paint();
        sPaint.setColor(ContextCompat.getColor(getContext(),R.color.bue));
        sPaint.setStrokeWidth(50);
        sPaint.setStyle(Paint.Style.FILL);
        txtPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        txtPaint.setColor(Color.parseColor("#000000"));
        txtPaint.setTextSize(35);
        txtPaint.setStrokeWidth(4);
        txtPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w/2;
        mHeight = h;
        rectTop = 200;
        rectTop2 = 200;
    }

    public void setZhu(int max,int max2){
        rectTop = mHeight-(max*5);
        rectTop2 = mHeight-(max2*5);
        zhuTxt1 = String.valueOf(max);
        zhuTxt2 = String.valueOf(max2);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //柱状图上的值
        canvas.drawText(zhuTxt1,mWidth-180,rectTop-10,txtPaint);
        canvas.drawText(zhuTxt2,mWidth+130,rectTop2-10,txtPaint);
        //圆角矩形
        canvas.drawRoundRect(mWidth-250,rectTop,mWidth-50,mHeight,20,20,bPaint);
        canvas.drawRoundRect(mWidth+50,rectTop2,mWidth+250,mHeight,20,20,sPaint);
    }
}
