package com.example.olayg.buttonchallenge.data.remote;

import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.util.Constants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by olayg on 2/28/2018.
 */

public interface FakeButtonService {
    @GET(Constants.USERS_PATH)
    Observable<List<User>> getUserList(
            @Query("candidate") String candidate
    );

    @POST(Constants.USERS_PATH)
    Observable<User> addUser(@Body User user
    );
}
