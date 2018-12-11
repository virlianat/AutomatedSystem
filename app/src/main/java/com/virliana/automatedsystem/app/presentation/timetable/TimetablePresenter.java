package com.virliana.automatedsystem.app.presentation.timetable;

import javax.inject.Inject;

public class TimetablePresenter {
    TimetableView timetableView;

    @Inject
    TimetablePresenter() {

    }

    void setTimetableView(TimetableView timetableView) {
        this.timetableView = timetableView;

    }


}
