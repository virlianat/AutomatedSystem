package com.virliana.automatedsystem.app.presentation.timetable;

import com.virliana.automatedsystem.app.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class TimetableModule {
    private TimetableActivity timetableActivity;

    TimetableModule(TimetableActivity timetableActivity) {
        this.timetableActivity = timetableActivity;
    }

    @Provides
    @PerActivity
    TimetableActivity provideTimetableActivity() {
        return timetableActivity;
    }
}