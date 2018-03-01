package com.example.olayg.buttonchallenge.view.homescreen;

import com.example.olayg.buttonchallenge.Constants;
import com.example.olayg.buttonchallenge.data.entities.User;

import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import timber.log.Timber;

/**
 * Created by olayg on 2/28/2018.
 */

public class HomeScreenPresenter implements HomeScreenContract.Presenter {

    private HomeScreenContract.View view;
    private Retrofit retrofit;

    @Inject
    public HomeScreenPresenter(HomeScreenContract.View view, Retrofit retrofit) {
        this.view = view;
        this.retrofit = retrofit;
    }

    @Override
    public void getUsers(String candidate) {
        retrofit.create(FakeButtonService.class).getUserList(candidate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<User>>() {
                    @DebugLog
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @DebugLog
                    @Override
                    public void onNext(List<User> users) {
                            Timber.d("User 1 is: " + users.size());

                    }

                    @DebugLog
                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @DebugLog
                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void postUser(User user) {
        retrofit.create(FakeButtonService.class).addUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @DebugLog
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @DebugLog
                    @Override
                    public void onNext(User user) {

                    }
                    @DebugLog
                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }
                    @DebugLog
                    @Override
                    public void onComplete() {

                    }
                });
    }

    private interface FakeButtonService {
        @GET(Constants.USERS_PATH)
        Observable<List<User>> getUserList(
                @Query("candidate") String candidate
        );

        @POST(Constants.USERS_PATH)
        Observable<User> addUser(@Body User user
        );
    }
}

