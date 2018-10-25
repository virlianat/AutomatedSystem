package com.virliana.automatedsystem.app.presentation.home;

import com.virliana.automatedsystem.app.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {

    void inject(HomeFragment homeFragment);

}
