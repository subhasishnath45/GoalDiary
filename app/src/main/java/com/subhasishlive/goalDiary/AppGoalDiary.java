package com.subhasishlive.goalDiary;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by SubhasishNath on 6/2/2018.
 */

// created my application class..
// unlike activities, applications are never destroyed...
public class AppGoalDiary extends Application {
    // unlike activities, application is never destroyed.....
    @Override
    public void onCreate() {
        super.onCreate();
// initialize Realm
        Realm.init(getApplicationContext());
        RealmConfiguration configuration=new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);

    }
}
