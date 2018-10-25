package com.virliana.automatedsystem.app;

import com.virliana.automatedsystem.app.presentation.home.HomeComponent;
import com.virliana.automatedsystem.app.presentation.home.HomeModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    HomeComponent createHomeComponent(HomeModule homeModule);
}
