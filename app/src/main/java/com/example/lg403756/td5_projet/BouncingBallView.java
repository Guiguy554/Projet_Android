package com.example.lg403756.td5_projet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;

import java.util.Random;


public class BouncingBallView extends View {

    private Context mContext;

    int x = -1;
    int y = -1;
    private int xVelocity = 5; // direction initiale
    private int yVelocity = 5; // Direction initiale
    private Handler h;
    private final long FRAME_RATE = 10;
    private BitmapDrawable image;

    // Constructor
    @SuppressLint("WrongViewCast")
    public BouncingBallView(Context context,BitmapDrawable pict)  {
        super(context);
        Random ra = new Random();
        xVelocity = (ra.nextInt(5)-5);
        yVelocity = (ra.nextInt(5)-5);
        mContext = context;
        image = pict;
        h = new Handler();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    protected void onDraw(Canvas c) {
        BitmapDrawable ball = image; //(BitmapDrawable) mContext.getResources().getDrawable(R.drawable.bike);
        BitmapDrawable falseball = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.bike);
        //Random ra = new Random();
        //xVelocity = (ra.nextInt(5)-5);
        //yVelocity = (ra.nextInt(5)-5);
        //x = (ra.nextInt(getWidth()));
        //y = (ra.nextInt(getHeight()));
        if (x<0 && y <0) {
            x = this.getWidth()/2;
            y = this.getHeight()/2;
        } else {
            x += (xVelocity * 4);
            y += (yVelocity * 4);
            if(x <= 0 && y <= 0){
                x = 1;
                y = 1;
                xVelocity = xVelocity*-1;
                yVelocity = yVelocity*-1;
            }
            if ((x > this.getWidth() - ball.getBitmap().getWidth()) || (x < 0)) {
                xVelocity = xVelocity*-1;
            }
            if ((y > this.getHeight() - ball.getBitmap().getHeight()) || (y < 0)) {
                yVelocity = yVelocity*-1;
            }
        }
        c.drawBitmap(ball.getBitmap(), x, y, null);
        h.postDelayed(r, FRAME_RATE);
    }
}