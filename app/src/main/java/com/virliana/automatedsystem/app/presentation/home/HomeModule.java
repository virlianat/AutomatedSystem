package com.virliana.automatedsystem.app.presentation.home;

import com.virliana.automatedsystem.app.PerActivity;
import com.virliana.automatedsystem.app.presentation.home.HomeActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    private HomeActivity homeActivity;

    HomeModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @PerActivity
    HomeActivity provideHomeActivity() {
        return homeActivity;
    }

}

