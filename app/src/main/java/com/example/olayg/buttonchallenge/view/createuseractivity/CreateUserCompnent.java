package com.example.olayg.buttonchallenge.view.createuseractivity;

import com.example.olayg.buttonchallenge.util.CustomScope;
import com.example.olayg.buttonchallenge.data.component.NetComponent;

import dagger.Component;

/**
 * Created by olayg on 2/28/2018.
 */
@CustomScope
@Component(modules = {CreateUserModule.class}, dependencies = {NetComponent.class})
public interface CreateUserCompnent {
    void inject(CreateUser createUser);
}
