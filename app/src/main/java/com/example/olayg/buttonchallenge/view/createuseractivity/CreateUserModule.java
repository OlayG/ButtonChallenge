package com.example.olayg.buttonchallenge.view.createuseractivity;

import com.example.olayg.buttonchallenge.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by olayg on 2/28/2018.
 */
@Module
public class CreateUserModule {
    private final CreateUserContract.View view;

    public CreateUserModule(CreateUserContract.View view) {
        this.view = view;
    }

    @CustomScope
    @Provides
    CreateUserContract.View providesCreateUserContractView() {
        return view;
    }
}
