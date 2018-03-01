package com.example.olayg.buttonchallenge.view.homescreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.olayg.buttonchallenge.App;
import com.example.olayg.buttonchallenge.util.Constants;
import com.example.olayg.buttonchallenge.R;
import com.example.olayg.buttonchallenge.adapter.RecyclerItemClickListener;
import com.example.olayg.buttonchallenge.adapter.UserAdapter;
import com.example.olayg.buttonchallenge.data.entities.User;
import com.example.olayg.buttonchallenge.view.base.BaseActivity;
import com.example.olayg.buttonchallenge.view.createuseractivity.CreateUser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;

public class HomeScreen extends BaseActivity implements HomeScreenContract.View, RecyclerItemClickListener.OnRecyclerClickListener {

    @Inject
    HomeScreenPresenter presenter;
    @BindView(R.id.rvUsers)
    RecyclerView rvUsers;
    private UserAdapter userAdapter;

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);
        activateToolbar(false);
        setupDagger();
        setupRecyclerView();
        presenter.getUsers(Constants.CANDIDATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getUsers(Constants.CANDIDATE);
    }

    private void setupRecyclerView() {
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        rvUsers.addOnItemTouchListener(new RecyclerItemClickListener(this, rvUsers, this));
        rvUsers.setLayoutTransition(null);
        rvUsers.setFocusableInTouchMode(true);
        userAdapter = new UserAdapter(new ArrayList<User>());
        userAdapter.hasStableIds();
        rvUsers.setAdapter(userAdapter);
    }


    private void setupDagger() {
        DaggerHomeScreenComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .homeScreenModule(new HomeScreenModule(this))
                .build().inject(this);
    }

    @OnClick({R.id.fabAddUser})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fabAddUser:
                startActivity(new Intent(this, CreateUser.class));
                break;
        }
    }

    @DebugLog
    @Override
    public void loadUsers(List<User> users) {
        userAdapter.loadNewData(users);
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

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
