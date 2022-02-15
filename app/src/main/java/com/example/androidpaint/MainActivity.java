package com.example.androidpaint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new MyDraw(this));
//        setContentView(R.layout.activity_main);
    }
}

class MyDraw extends View {
    public MyDraw (Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setAntiAlias(true);
        paint.setColor(Color.rgb(254,77,77));
        canvas.drawCircle(getWidth() / 2, getHeight() / 3, 200, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(0, 0, getWidth(),380, paint);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(80);
        canvas.drawText("Nice Day", 50, 100, paint);
        float rotate_center_x = 150;
        float rotate_center_y = 530;
        float rotate_angle = 90;
        canvas.rotate(-rotate_angle, rotate_center_x, rotate_center_y);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("Luck",0,550,paint);
        canvas.rotate(rotate_angle, rotate_center_x, rotate_center_y);
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.img);
        int xx = canvas.getWidth(), yy = canvas.getHeight();
        canvas.drawBitmap(image, xx - image.getWidth(), yy - image.getHeight(), paint);
    }
}
