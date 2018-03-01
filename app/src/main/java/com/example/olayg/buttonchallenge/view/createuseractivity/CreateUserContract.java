package com.example.olayg.buttonchallenge.view.createuseractivity;

import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.view.base.BasePresenter;
import com.example.olayg.buttonchallenge.view.base.BaseView;

/**
 * Created by olayg on 2/28/2018.
 */

public interface CreateUserContract {

    interface View extends BaseView {
        void closeActivity();
    }

    interface Presenter extends BasePresenter {
        void postUser(User user);
    }
}
