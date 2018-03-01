package com.example.olayg.buttonchallenge;

import com.example.olayg.buttonchallenge.view.homescreen.HomeScreenContract;
import com.example.olayg.buttonchallenge.view.homescreen.HomeScreenPresenter;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import retrofit2.Retrofit;

/**
 * Created by olayg on 3/1/2018.
 */

public class HomeScreenPresenterTest {

    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    HomeScreenContract.View view;
    @Mock
    Retrofit retrofit;
    @InjectMocks private HomeScreenPresenter presenter;

    @Test
    public void getUsers_displayUsersHomeScreenUI(){

      //  verify(presenter).getUsers();




    }
}
