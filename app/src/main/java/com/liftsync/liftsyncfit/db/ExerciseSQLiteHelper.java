package com.liftsync.liftsyncfit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by seufster on 1/15/15.
 */
public class ExerciseSQLiteHelper extends SQLiteOpenHelper {

    public static final String TAG = "ExerciseSQLiteHelper";

    private static final String DATABASE_NAME = "lift_sync.db";
    private static final int DATABASE_VERSION = 1;

    public ExerciseSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
       // FuLogger.v(FuLogger.TRACE, TAG, "construct run sql helper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create prefereneces
        //FuLogger.v(FuLogger.TRACE, TAG,"Creating table preferences");
        db.execSQL("create table preferences ( _id integer primary key autoincrement," +
                "_key text not null, _value text not null);");
        db.execSQL("create index pref_idx on preferences (_key)");

        // preset params
        ContentValues valueU = new ContentValues();
        valueU.put("_key", "Units");
        valueU.put("_value", 0);
        db.insert("preferences", null, valueU);
        ContentValues valueV = new ContentValues();
        valueV.put("_key","VoiceThreshold");
        valueV.put("_value",2);
        db.insert("preferences", null, valueV);
        ContentValues valueT = new ContentValues();
        valueT.put("_key","Type");
        valueT.put("_value",1);
        db.insert("preferences", null, valueT);

        // create run_event
        //FuLogger.v(FuLogger.TRACE, TAG,"Creating table exercise_event");
        db.execSQL("create table exercise_event ( _id integer primary key autoincrement," +
                "exercise_start integer not null, exercise_end integer not null, elapsed_time integer not null, total_distance real not null," +
                "avg_pace integer not null, units integer not null, type integer not null, synced integer not null, path blob not null);");
        db.execSQL("create index exercise_idx on exercise_event (exercise_start)");

        // create stats
        //FuLogger.v(FuLogger.TRACE, TAG,"Creating table stats");
        db.execSQL("create table stats ( _id integer primary key autoincrement," +
                "_key text not null, _value text not null);");
        db.execSQL("create index stat_idx on stats (_key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //FuLogger.v(FuLogger.TRACE, TAG,"Upgrading database from version " + oldVersion + " to "
        //        + newVersion + ", which will destroy all old data");
        //FuLogger.v(FuLogger.TRACE, TAG,"Dropping table preferences");
        db.execSQL("DROP INDEX IF EXISTS pref_idx");
        db.execSQL("DROP TABLE IF EXISTS exercise_idx");
        db.execSQL("DROP TABLE IF EXISTS stat_idx");

        db.execSQL("DROP TABLE IF EXISTS preferences");
        db.execSQL("DROP TABLE IF EXISTS exercise_event");
        db.execSQL("DROP TABLE IF EXISTS stats");
        onCreate(db);
    }
}
