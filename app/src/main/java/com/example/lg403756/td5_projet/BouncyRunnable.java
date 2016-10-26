package com.example.lg403756.td5_projet;

import android.content.Context;
import android.view.View;

/**
 * Created by lg403756 on 18/10/2016.
 */

public class BouncyRunnable implements Runnable {

    private View bw;
    private Context c;

    public BouncyRunnable (Context mContext,View b){
        c = mContext;
        bw = b;
    }

    @Override
    public void run() {

    }
}
