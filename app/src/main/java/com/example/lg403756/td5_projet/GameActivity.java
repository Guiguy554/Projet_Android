package com.example.lg403756.td5_projet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by lg403756 on 17/10/2016.
 */

public class GameActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        final TextView t = (TextView) findViewById(R.id.GameTX);

        int colorIndex = getIntent().getIntExtra("color",0);
        int lvlIndex = getIntent().getIntExtra("lvl",1);

        t.setText("Color : "+String.valueOf(colorIndex) +"\nLvl : "+String.valueOf(lvlIndex) );
    }
}
