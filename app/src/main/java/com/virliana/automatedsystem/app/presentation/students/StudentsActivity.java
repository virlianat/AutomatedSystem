package com.virliana.automatedsystem.app.presentation.students;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.AppComponent;
import com.virliana.automatedsystem.app.AutomatedSystem;
import com.virliana.automatedsystem.app.HasDependencies;

public class StudentsActivity extends AppCompatActivity implements HasDependencies<StudentsComponent> {

    private StudentsComponent studentsComponent;

    public static void startFrom(Activity activityFrom) {
        final Intent intent = new Intent(activityFrom, StudentsActivity.class);
        activityFrom.startActivity(intent);
        activityFrom.finish();
        activityFrom.overridePendingTransition(R.anim.fade_in_medium, R.anim.fade_out_medium);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getFragmentManager().beginTransaction()
                .replace(R.id.fl_content_place, new StudentsFragment())
                .commit();
    }

    @Override
    public StudentsComponent getDependencies() {
        if (studentsComponent == null) {
            AutomatedSystem application = (AutomatedSystem) getApplicationContext();
            AppComponent appComponent = application.getAppComponent();
            studentsComponent = appComponent.createStudentsComponent(new StudentsModule(this));
        }
        return studentsComponent;
    }
}
