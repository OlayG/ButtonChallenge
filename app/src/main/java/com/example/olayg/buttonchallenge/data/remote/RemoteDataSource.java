package com.example.olayg.buttonchallenge.data.remote;

import com.example.olayg.buttonchallenge.data.entities.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by olayg on 3/1/2018.
 */

public class RemoteDataSource implements FakeButtonService {

    private FakeButtonService api;

    public RemoteDataSource(Retrofit retrofit) {
        this.api = retrofit.create(FakeButtonService.class);
    }

    @Override
    public Observable<List<User>> getUserList(String candidate) {
        return api.getUserList(candidate);
    }

    @Override
    public Observable<User> addUser(User user) {
        return api.addUser(user);
    }
}
