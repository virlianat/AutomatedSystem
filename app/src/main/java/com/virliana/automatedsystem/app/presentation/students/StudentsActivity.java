package com.virliana.automatedsystem.app.presentation.students;

import android.app.Activity;
import android.os.Bundle;

import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.AppComponent;
import com.virliana.automatedsystem.app.AutomatedSystem;
import com.virliana.automatedsystem.app.HasDependencies;

public class StudentsActivity extends Activity implements HasDependencies<StudentsComponent> {

    private StudentsComponent studentsComponent;

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
