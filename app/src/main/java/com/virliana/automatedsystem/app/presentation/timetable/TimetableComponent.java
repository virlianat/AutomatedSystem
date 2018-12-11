package com.virliana.automatedsystem.app.presentation.timetable;

import com.virliana.automatedsystem.app.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = TimetableModule.class)
public interface TimetableComponent {

    void inject(TimetableFragment timetableFragment);

}