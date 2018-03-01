package com.example.olayg.buttonchallenge.data.component;

import android.content.SharedPreferences;

import com.example.olayg.buttonchallenge.data.module.AppModule;
import com.example.olayg.buttonchallenge.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by olayg on 2/28/2018.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    SharedPreferences preferences();
}
