package com.example.olayg.buttonchallenge.view.homescreen;

import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.data.remote.RemoteDataSource;

import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by olayg on 2/28/2018.
 */

public class HomeScreenPresenter implements HomeScreenContract.Presenter {

    private HomeScreenContract.View view;
    private RemoteDataSource remoteDataSource;

    @Inject
    public HomeScreenPresenter(HomeScreenContract.View view, RemoteDataSource remoteDataSource) {
        this.view = view;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getUsers(String candidate) {
        remoteDataSource.getUserList(candidate)
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
                        view.loadUsers(users);
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
}

