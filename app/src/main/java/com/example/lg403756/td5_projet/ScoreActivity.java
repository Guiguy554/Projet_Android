package com.example.lg403756.td5_projet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by lg403756 on 31/10/2016.
 */

public class ScoreActivity extends  Activity  {

    public Realm realm;
    int score = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoring_layout);
        Intent i = getIntent();

        int scoreInt = i.getIntExtra("score",0);
        final TextView scoringText = (TextView)  findViewById(R.id.scoring);
        scoringText.setText("Score = "+Integer.toString(scoreInt));


        //realm = Realm.getInstance((Context)this);
        realm.init(this);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(o1 < o2){
                    return 1;
                }else if(o1 > o2){
                    return -1;
                }else{
                    return 0;
                }
            }
        };

        Score s = new Score();
        Number queryMax = realm.where(Score.class).findAll().max("idScore");
        int val;
        if(queryMax == null){
            val = 1;
        }else{
            val = queryMax.intValue();
        }
        s.setScore(scoreInt);
        s.setIdScore(val+1);

        realm.copyToRealmOrUpdate(s);

        realm.commitTransaction();

        RealmResults<Score> req = realm.where(Score.class).greaterThan("score",0).findAll();
        //realm.close();

        ArrayList<Integer> tabR = new ArrayList<Integer>();
        RealmList<Score> tabS = new RealmList<Score>();
        tabS.addAll(req.subList(0,req.size()));
        for(int j =0; j<req.size();j++){
            tabR.add(tabS.get(j).getScore());
        }
        Collections.sort(tabR,Collections.reverseOrder());
        /*
        SharedPreferences sharedP = this.getSharedPreferences("score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedP.edit();


        String saveName = "Score";
        int saveID = 1;
        while(sharedP.getAll().keySet().contains(saveName+Integer.toString(saveID))){
            saveID +=1;
        }
        editor.putInt(saveName+Integer.toString(saveID),score);
        editor.apply();
        sharedP = this.getSharedPreferences("score", Context.MODE_PRIVATE);


        HashSet<Integer> hset=new HashSet<Integer>();
        hset.addAll((Collection<? extends Integer>) sharedP.getAll().values());
*/
        //ArrayList<Integer> LIST = new ArrayList<Integer>((Score[])req.toArray());
           //Comparateur de score
        /*Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2){
                    return 1;
                }else if(o1 > o2){
                    return -1;
                }else{
                    return 0;
                }
            }
        };*/
        //Collections.sort(LIST,comp);
        Log.e("RESULTATS REQ : ",req.toString() );
        Log.e("FORMAT : ",req.getClass().toString() );

        //Insertion dans la liste
        final ListView l = (ListView)findViewById(R.id.scoreList);
        ArrayAdapter<Integer> adapt = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,tabR);
        l.setAdapter(adapt);


    }
}
