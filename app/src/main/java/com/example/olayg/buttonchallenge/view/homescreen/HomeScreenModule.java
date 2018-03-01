package com.example.olayg.buttonchallenge.view.homescreen;

import com.example.olayg.buttonchallenge.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by olayg on 2/28/2018.
 */
@Module
public class HomeScreenModule {
    private final HomeScreenContract.View view;

    public HomeScreenModule(HomeScreenContract.View view) {
        this.view = view;
    }

    @CustomScope
    @Provides
    HomeScreenContract.View providesMainActivityContractView() {
        return view;
    }
}
