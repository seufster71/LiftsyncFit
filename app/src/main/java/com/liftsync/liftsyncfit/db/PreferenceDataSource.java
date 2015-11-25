package com.liftsync.liftsyncfit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by seufster on 1/15/15.
 */
public class PreferenceDataSource {

    private static final String TAG = "PreferenceDataSource";
    // Database fields
    private SQLiteDatabase database;
    private ExerciseSQLiteHelper dbHelper;
    private String[] allColumns = { "_id","_key","_value" };

    public PreferenceDataSource(Context context){
        //FuLogger.v(FuLogger.TRACE,TAG, "construct preference data source");
        dbHelper = new ExerciseSQLiteHelper(context);
    }

    public void openRead() { database = dbHelper.getReadableDatabase(); }

    public void openWrite() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Preference createPreference(String key, String value){
        ContentValues values = new ContentValues();
        values.put("_key",key);
        values.put("_value",value);
        long insertId = database.insert("preferences", null, values);
        Cursor cursor = database.query("preferences", allColumns, "_id = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Preference newPreference = cursorToPreference(cursor);
        cursor.close();
        return newPreference;
    }

    public void updatePreference(Preference preference){
        database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_value",preference.getValue());
        database.update("preferences",values,"_id = " + preference.getId(), null);
    }

    public void deletePreference(Preference preference){
        long id = preference.getId();
        database.delete("preference", "_id = " + id, null);
    }

    public Map<String,Preference> getAllPreferences(){
        Map<String,Preference> prefs = new HashMap<String,Preference>();
        Cursor cursor = database.query("preferences",allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Preference preference = cursorToPreference(cursor);
            prefs.put(preference.getKey(),preference);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return prefs;
    }

    private Preference cursorToPreference(Cursor cursor){
        Preference preference = new Preference();
        preference.setId(cursor.getLong(0));
        preference.setKey(cursor.getString(1));
        preference.setValue(cursor.getString(2));
        return preference;
    }
}
