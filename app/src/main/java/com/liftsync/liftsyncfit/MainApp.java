package com.liftsync.liftsyncfit;

import android.app.Application;

import com.liftsync.liftsyncfit.db.Preference;
import com.liftsync.liftsyncfit.db.PreferenceDataSource;


import java.util.Map;

/**
 * Created by seufster on 11/25/15.
 */
public class MainApp extends Application {

    public static final String TAG = "MainApp";
    private static Map<String,Preference> preferences = null;
    private static PreferenceDataSource preferenceDataSource = null;


    public Map<String, Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<String, Preference> preferences) {
        this.preferences = preferences;
    }

    public PreferenceDataSource getPreferenceDataSourceInstance() {
        if (preferenceDataSource == null) {
            preferenceDataSource = new PreferenceDataSource(getApplicationContext());
        }
        return preferenceDataSource;
    }
}
