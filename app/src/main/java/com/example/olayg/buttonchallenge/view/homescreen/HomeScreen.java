package com.example.olayg.buttonchallenge.view.homescreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.olayg.buttonchallenge.App;
import com.example.olayg.buttonchallenge.Constants;
import com.example.olayg.buttonchallenge.R;
import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.view.base.BaseActivity;
import com.example.olayg.buttonchallenge.view.createuseractivity.CreateUser;
import com.example.olayg.buttonchallenge.view.createuseractivity.UserEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;

public class HomeScreen extends BaseActivity implements HomeScreenContract.View {

    @Inject
    HomeScreenPresenter presenter;
    @Inject
    SharedPreferences preferences;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);
        activateToolbar(false);
        setupDagger();
    }

    @DebugLog
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().register(this);
    }


    private void setupDagger() {
        DaggerHomeScreenComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .homeScreenModule(new HomeScreenModule(this))
                .build().inject(this);
    }

    @OnClick({R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab:
                startActivity(new Intent(this, CreateUser.class));
                break;
        }
    }

    @Override
    public void loadUsers(List<User> users) {

    }

    @Override
    public void createNewUser(User user) {
        presenter.postUser(user);
    }

    @Override
    public void showError(String error) {
        AlertDialog.Builder errorDialogBuilder = new AlertDialog.Builder(this);
        errorDialogBuilder.setMessage(error);
        errorDialogBuilder.setCancelable(true);

        errorDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog errorDialog = errorDialogBuilder.create();
        errorDialog.show();
    }

    @DebugLog
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewUserEvent(UserEvent userEvent) {
        if (userEvent.getUser() != null)
            createNewUser(userEvent.getUser());
        else
            showError(getString(R.string.generic_error_message));
    }
}
