package com.example.lg403756.td5_projet;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity2 extends Activity {
    /** Called when the activity is first created. */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        View bw = new BouncingBallView(this,(BitmapDrawable) getDrawable(R.drawable.bike3));  //(R.drawable.bike3));
        View bw2 = new BouncingBallView(this,(BitmapDrawable) getDrawable(R.drawable.bike4));
        setContentView(bw);
        addContentView(bw2, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        //bw.setBackgroundColor(Color.WHITE);

        //Thread t1 = new Thread(new BouncyRunnable(bouncingBallView));
    }
}
