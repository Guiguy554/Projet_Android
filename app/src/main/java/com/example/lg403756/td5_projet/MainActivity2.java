package com.example.lg403756.td5_projet;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    /** Called when the activity is first created. */

    int score = 0;
    int time = 15;
    Thread timer;
    int status = 1; // 1: alive ; -1: dead ; 0: paused
    private MediaPlayer mMediaPlayer;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        int lvl = i.getIntExtra("lvl",0);
        int diff = i.getIntExtra("diff",0);
        String resName = i.getStringExtra("name");
        int colorID = i.getIntExtra("color",1);
        mMediaPlayer = MediaPlayer.create(this, R.raw.mario);

        int vitesse = 1;
        int increment = 1;

        switch (lvl) {
            case 0 :case 1 :
                vitesse = 1;
                break;
            case 2 :
                vitesse = 2;
                break;
            case 3 :
                vitesse = 3;
                break;
            case 4 :
                vitesse = 4;
                break;
            case 5 :
                vitesse = 5;
                break;
            case 6 :
                vitesse = 6;
                break;
            case 7:
                vitesse = 7;
                break;
            case 8 :
                vitesse = 8;
                break;
            case 9: case 10:
                vitesse = 9;
                break;
            default:
                vitesse = 1;
        }

        View bw = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID),"drawable",this.getPackageName())),vitesse);
        View bw2 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID),"drawable",this.getPackageName())),vitesse);
        View bw3 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID),"drawable",this.getPackageName())),vitesse);
        View bw4 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID),"drawable",this.getPackageName())),vitesse);
        View bw5 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID),"drawable",this.getPackageName())),vitesse);

        switch (diff){
            case 1 :
                if(colorID == 5){
                    increment = -1;
                }
                bw2 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+increment),"drawable",this.getPackageName())),vitesse);
                bw3 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+increment),"drawable",this.getPackageName())),vitesse);
                bw4 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+increment),"drawable",this.getPackageName())),vitesse);
                bw5 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+increment),"drawable",this.getPackageName())),vitesse);
                break;
            case 2:
                bw2 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(getRandomWithExclusion(new Random(),1,5,colorID)),"drawable",this.getPackageName())),vitesse);
                bw3 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(getRandomWithExclusion(new Random(),1,5,colorID)),"drawable",this.getPackageName())),vitesse);
                bw4 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(getRandomWithExclusion(new Random(),1,5,colorID)),"drawable",this.getPackageName())),vitesse);
                bw5 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(getRandomWithExclusion(new Random(),1,5,colorID)),"drawable",this.getPackageName())),vitesse);
                break;
            case 3:
                bw2 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(getRandomStringWithExclusion(new Random(),0,4,resName)+Integer.toString(getRandomWithExclusion(new Random(),1,5,colorID)),"drawable",this.getPackageName())),vitesse);
                bw3 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(getRandomStringWithExclusion(new Random(),0,4,resName)+Integer.toString(getRandomWithExclusion(new Random(),1,5,colorID)),"drawable",this.getPackageName())),vitesse);
                bw4 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(getRandomStringWithExclusion(new Random(),0,4,resName)+Integer.toString(getRandomWithExclusion(new Random(),1,5,colorID)),"drawable",this.getPackageName())),vitesse);
                bw5 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(getRandomStringWithExclusion(new Random(),0,4,resName)+Integer.toString(getRandomWithExclusion(new Random(),1,5,colorID)),"drawable",this.getPackageName())),vitesse);

                break;
            default :
                if(colorID == 5){
                    increment = -1;
                }
                bw2 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+increment),"drawable",this.getPackageName())),vitesse);
                bw3 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+increment),"drawable",this.getPackageName())),vitesse);
                bw4 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+increment),"drawable",this.getPackageName())),vitesse);
                bw5 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+increment),"drawable",this.getPackageName())),vitesse);
                break;
        }

        /*
        View bw2 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+2),"drawable",this.getPackageName())),lvl);
        View bw3 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+2),"drawable",this.getPackageName())),lvl);
        View bw4 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+2),"drawable",this.getPackageName())),lvl);
        View bw5 = new BouncingBallView(this,(BitmapDrawable)getDrawable(getResources().getIdentifier(resName+Integer.toString(colorID+2),"drawable",this.getPackageName())),lvl);
        */

        View.OnTouchListener myListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BouncingBallView bv = (BouncingBallView) v;
                int evt1 = (int) event.getX();
                int evt2 = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    if ( (evt1 >= bv.x && evt1 <= (bv.x + bv.width)) && (evt2 >= bv.y && evt2 <= (bv.y + bv.height)) ) {
                        score += 1;
                        TextView t = (TextView) findViewById(R.id.score);
                        t.setText(Integer.toString(score));

                        mMediaPlayer.start();

                        Vibrator mVibrator = (Vibrator) getSystemService(Activity.VIBRATOR_SERVICE);
                        mVibrator.vibrate(100);
                    }
                }
                bv = null;
                return true;
            }
        };
        bw.setOnTouchListener(myListener);
        addContentView(bw, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        addContentView(bw2, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        addContentView(bw3, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        addContentView(bw4, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        addContentView(bw5, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int sec = time%60;
                int min = time/60;
                while(time > 0){
                    time -= 1;

                    try {
                        runOnUiThread(new Runnable() {
                            int sec = time%60;
                            int min = time/60;
                            @Override
                            public void run() {
                                updateTimer(min,sec);
                            }
                        });
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        if(status == -1){
                            break;
                        }else{
                            while(status != 1){

                            }
                        }

                    }
                }
                if(time == 0){
                    Intent i2 = new Intent(MainActivity2.this, ScoreActivity.class);
                    i2.putExtra("score", score);
                    startActivity(i2);
                }

            }
        });
        timer.start();
    }
    @Override
    protected void onResume(){
        status = 1;
        timer.interrupt();
        super.onResume();
    }
    @Override
    protected void onPause(){
        status = 0;
        //timer.interrupt();
        /*new AlertDialog.Builder(this).setTitle("Test").setMessage("Do you want to quit ?").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Toast.makeText(MainActivity2.this, "Yaay", Toast.LENGTH_SHORT).show();
                System.exit(0);
            }})
                .setNegativeButton(android.R.string.no, null).show();*/
        super.onPause();
        //onResume();
    }
    @Override
    protected void onDestroy(){
        status = -1;
        timer.interrupt();
        super.onDestroy();
        //timer.interrupt();
        //timer = null;
    }
    //
    // Trouver sur : http://stackoverflow.com/questions/6443176/how-can-i-generate-a-random-number-within-a-range-but-exclude-some
    //
    public int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    public String getRandomStringWithExclusion(Random rnd, int start, int end, String... exclude) {
        int random = start + rnd.nextInt(end - start + 1) ;//- exclude.length);
        String[] tabVal = {"voiture","avion","camion","cheval","velo"};
        for (String ex : exclude) {
            if (tabVal[random] != ex) {
                break;
            }
            random++;
        }
        return tabVal[random];
    }

    public void updateTimer(int m, int s){
        TextView t = (TextView) findViewById(R.id.timeLeft);
        t.setText( Integer.toString(m) + " : " + Integer.toString(s));
    }
}
