package com.virliana.automatedsystem.app.presentation.students;

import com.virliana.automatedsystem.app.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = StudentsModule.class)
public interface StudentsComponent {

    void inject(StudentsFragment studentsFragment);

}