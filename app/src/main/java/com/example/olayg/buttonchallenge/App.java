package com.example.olayg.buttonchallenge;

import android.app.Application;

import com.example.olayg.buttonchallenge.data.component.DaggerNetComponent;
import com.example.olayg.buttonchallenge.data.component.NetComponent;
import com.example.olayg.buttonchallenge.data.module.AppModule;
import com.example.olayg.buttonchallenge.data.module.NetModule;

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
        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .appModule(new AppModule(this))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
