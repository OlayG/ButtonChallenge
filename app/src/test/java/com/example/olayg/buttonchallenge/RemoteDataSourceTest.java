package com.example.olayg.buttonchallenge;

import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.data.remote.RemoteDataSource;
import com.example.olayg.buttonchallenge.util.Constants;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.TestObserver;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by olayg on 3/1/2018.
 */

public class RemoteDataSourceTest {

    List<User> resultList;
    MockWebServer mockWebServer;
    TestObserver<List<User>> subscriber;

    @Before
    public void setUp() {
        User man = new User();
        man.setName("James Harden");
        man.setEmail("jharden@rockets.com");
        man.setCandidate("asdfjkl");
        User woman = new User();
        woman.setName("Lola Jones");
        woman.setEmail("ljones@usatrack.com");
        woman.setCandidate("asdfjkl");
        resultList = new ArrayList<>();
        resultList.add(man);
        resultList.add(woman);

        mockWebServer = new MockWebServer();
        subscriber = new TestObserver<>();
    }

    @Test
    public void serverCallWithError() {
        //Given
        String url = "dfdf/";
        mockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(resultList)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mockWebServer.url(url))
                .build();
        RemoteDataSource remoteDataSource = new RemoteDataSource(retrofit);

        //When
        remoteDataSource.getUserList("asdfjkl").subscribe(subscriber);

        //Then
        subscriber.assertNoErrors();
        subscriber.assertComplete();
    }

    @Test
    public void serverCallWithSuccess() {
        //Given
        String url = Constants.BASE_URL;
        mockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(resultList)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mockWebServer.url(url))
                .build();
        RemoteDataSource remoteDataSource = new RemoteDataSource(retrofit);

        //When
        remoteDataSource.getUserList("asdfjkl").subscribe(subscriber);

        //Then
        subscriber.assertNoErrors();
        subscriber.assertComplete();
    }


}
