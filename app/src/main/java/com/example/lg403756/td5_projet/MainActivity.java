package com.example.lg403756.td5_projet;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String[] gridColors = new String[] {
            String.valueOf(Color.BLACK),
            String.valueOf(Color.GREEN),
            String.valueOf(Color.BLUE),
            String.valueOf(Color.RED),
            String.valueOf(Color.YELLOW),
    };
    static final String[] gridValues = new String[] {
            "",
            "",
            "",
            "",
            "",
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ItemData> list=new ArrayList<>();
        list.add(new ItemData("Tuture",R.drawable.sportcar0));
        list.add(new ItemData("VionVion",R.drawable.airplane0));
        list.add(new ItemData("MionMion",R.drawable.lorry0));
        list.add(new ItemData("NeyNey",R.drawable.horse0));
        Spinner sp=(Spinner)findViewById(R.id.spinner);
        SpinnerAdapter adapter=new SpinnerAdapter(this,
                R.layout.spinner_layout,R.id.txt,list);
        sp.setAdapter(adapter);


        /*final GridView g = (GridView) findViewById(R.id.grid);
        ArrayAdapter<String> adapterG = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, gridValues);

        changeColors(g);*/

        final TextView t1= (TextView) findViewById(R.id.numberSeek);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        t1.setText("0");
        final SeekBar sk=(SeekBar) findViewById(R.id.seekBar);
        sk.setMax(10);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                t1.setText(String.valueOf(progress));
                //Toast.makeText(getApplicationContext(), String.valueOf(progress),Toast.LENGTH_LONG).show();

            }
        });

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = rg.getCheckedRadioButtonId();
                View radioButton = rg.findViewById(radioButtonID);
                int idx = rg.indexOfChild(radioButton);

                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("color",idx);
                i.putExtra("lvl",sk.getProgress());
                startActivity(i);
            }
        });


    }

    private void changeColors(GridView g) {
        g.getChildAt(0).setBackgroundColor(Color.BLACK);
        g.getChildAt(1).setBackgroundColor(Color.GREEN);
        g.getChildAt(2).setBackgroundColor(Color.BLUE);
        g.getChildAt(3).setBackgroundColor(Color.RED);
        g.getChildAt(4).setBackgroundColor(Color.YELLOW);
    }
}
