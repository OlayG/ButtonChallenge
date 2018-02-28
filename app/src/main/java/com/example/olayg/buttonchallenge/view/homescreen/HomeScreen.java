package com.example.olayg.buttonchallenge.view.homescreen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.olayg.buttonchallenge.App;
import com.example.olayg.buttonchallenge.R;
import com.example.olayg.buttonchallenge.view.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeScreen extends BaseActivity implements HomeScreenContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);
        activateToolbar(false);
        setupDagger();
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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
    }
}
