package com.dizzay.firebaselage;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by root on 6/20/16.
 */
public class AppEx extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
