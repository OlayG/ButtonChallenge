package com.example.olayg.buttonchallenge.data.component;

import com.example.olayg.buttonchallenge.App;
import com.example.olayg.buttonchallenge.data.module.AppModule;

import dagger.Component;

/**
 * Created by olayg on 2/28/2018.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);
}
