package com.virliana.automatedsystem.app.presentation.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.AppComponent;
import com.virliana.automatedsystem.app.AutomatedSystem;
import com.virliana.automatedsystem.app.HasDependencies;

public class TimetableActivity extends AppCompatActivity implements HasDependencies<TimetableComponent>

{

    private TimetableComponent timetableComponent;

    public static void startFrom(Activity activityFrom) {
        final Intent intent = new Intent(activityFrom, TimetableActivity.class);
        activityFrom.startActivity(intent);
        activityFrom.overridePendingTransition(R.anim.fade_in_medium, R.anim.fade_out_medium);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getFragmentManager().beginTransaction()
                .replace(R.id.fl_content_place, new TimetableFragment())
                .commit();
    }

    @Override
    public TimetableComponent getDependencies() {
        if (timetableComponent == null) {
            AutomatedSystem application = (AutomatedSystem) getApplicationContext();
            AppComponent appComponent = application.getAppComponent();
            timetableComponent = appComponent.createTimetableComponent(new TimetableModule(this));
        }
        return timetableComponent;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
