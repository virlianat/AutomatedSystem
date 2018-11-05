package com.virliana.automatedsystem.app.presentation.students;

import com.virliana.automatedsystem.app.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class StudentsModule {
    private StudentsActivity studentsActivity;

    StudentsModule(StudentsActivity studentsActivity) {
        this.studentsActivity = studentsActivity;
    }

    @Provides
    @PerActivity
    StudentsActivity provideStudentsActivity() {
        return studentsActivity;
    }
}
