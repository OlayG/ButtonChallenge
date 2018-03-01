package com.example.olayg.buttonchallenge.view.homescreen;

import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.view.base.BasePresenter;
import com.example.olayg.buttonchallenge.view.base.BaseView;

import java.util.List;

/**
 * Created by olayg on 2/28/2018.
 */

public interface HomeScreenContract {

    interface View extends BaseView {
        void loadUsers(List<User> users);
        void createNewUser(User user);
    }

    interface Presenter extends BasePresenter {
        void getUsers(String candidate);
        void postUser(User user);
    }
}
