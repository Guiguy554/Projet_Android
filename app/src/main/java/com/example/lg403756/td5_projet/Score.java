package com.example.lg403756.td5_projet;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by lg403756 on 28/11/2016.
 */

public class Score extends RealmObject {

    @PrimaryKey
    private int idScore;

    private int score;

    public int getIdScore() { return idScore; }
    public void setIdScore(int sco) { this.idScore = sco; }
    public int getScore() { return score; }
    public void setScore(int value) { this.score = value; }



}
