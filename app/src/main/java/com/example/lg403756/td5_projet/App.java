package com.example.lg403756.td5_projet;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by lg403756 on 05/12/2016.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);

    }
}
