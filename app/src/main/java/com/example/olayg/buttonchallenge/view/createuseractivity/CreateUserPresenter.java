package com.example.olayg.buttonchallenge.view.createuseractivity;

import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.data.remote.RemoteDataSource;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by olayg on 2/28/2018.
 */

public class CreateUserPresenter implements CreateUserContract.Presenter {

    CreateUserContract.View view;
    private RemoteDataSource remoteDataSource;

    @Inject
    public CreateUserPresenter(CreateUserContract.View view, RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.view = view;
    }

    @Override
    public void postUser(User user) {
        remoteDataSource.addUser(user)
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
                        view.closeActivity();
                    }
                });
    }
}
