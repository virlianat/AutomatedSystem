package com.virliana.automatedsystem.app;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    //HomeComponent createHomeComponent(HomeModule homeModule);
}
