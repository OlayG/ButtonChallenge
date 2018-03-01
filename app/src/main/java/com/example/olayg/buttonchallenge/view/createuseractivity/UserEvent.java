package com.example.olayg.buttonchallenge.view.createuseractivity;

import com.example.olayg.buttonchallenge.data.entities.User;

/**
 * Created by olayg on 2/28/2018.
 */

public class UserEvent {

    final User user;

    public UserEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
