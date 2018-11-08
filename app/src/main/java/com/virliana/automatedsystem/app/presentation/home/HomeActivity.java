package com.virliana.automatedsystem.app.presentation.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.AppComponent;
import com.virliana.automatedsystem.app.AutomatedSystem;
import com.virliana.automatedsystem.app.HasDependencies;

public class HomeActivity extends AppCompatActivity implements HasDependencies<HomeComponent> {

    private HomeComponent homeComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getFragmentManager().beginTransaction()
                .replace(R.id.fl_content_place, new HomeFragment())
                .commit();
    }

    @Override
    public HomeComponent getDependencies() {
        if (homeComponent == null) {
            AutomatedSystem application = (AutomatedSystem) getApplicationContext();
            AppComponent appComponent = application.getAppComponent();
            homeComponent = appComponent.createHomeComponent(new HomeModule(this));
        }
        return homeComponent;
    }
}
