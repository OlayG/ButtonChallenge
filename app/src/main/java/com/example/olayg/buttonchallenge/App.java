package com.example.olayg.buttonchallenge;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by olayg on 2/28/2018.
 */

public class App extends Application {
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupTimber();
        setupDagger();
    }

    private void setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void setupDagger() {

    }
}
