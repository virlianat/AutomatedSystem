package com.virliana.automatedsystem.app.presentation.home;

import android.os.Handler;

import javax.inject.Inject;

class HomePresenter {

    public static final String TAG = "HomePresenter";
    private Handler mainHandler;
    private HomeView homeView;

    @Inject
    HomePresenter() {
        this.mainHandler = new Handler();
    }

    void setHomeView(HomeView homeView) {
        this.homeView = homeView;
    }
}
