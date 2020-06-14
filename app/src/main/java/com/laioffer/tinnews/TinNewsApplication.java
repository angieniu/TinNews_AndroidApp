package com.laioffer.tinnews;

import android.app.Application;

import androidx.room.Room;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;
import com.facebook.stetho.Stetho;
import com.laioffer.tinnews.database.AppDatabase;

public class TinNewsApplication extends Application {
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Gander.setGanderStorage(GanderIMDB.getInstance());
        Stetho.initializeWithDefaults(this);
        // singleton
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "tin_db").build();
            }
// singleton, based on TinNewsApplication (singleton)
            public static AppDatabase getDatabase() {
                return database;

    }
}
