package com.virliana.automatedsystem.app;

import android.app.Application;

public class AutomatedSystem extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
