package com.example.olayg.buttonchallenge.data.component;

import com.example.olayg.buttonchallenge.data.module.AppModule;
import com.example.olayg.buttonchallenge.data.module.NetModule;
import com.example.olayg.buttonchallenge.data.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by olayg on 2/28/2018.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    RemoteDataSource remoteDataSource();
}
