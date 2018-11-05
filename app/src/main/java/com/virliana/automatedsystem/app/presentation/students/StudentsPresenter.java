package com.virliana.automatedsystem.app.presentation.students;

import javax.inject.Inject;

public class StudentsPresenter {

    private StudentsView studentsView;

    @Inject
    StudentsPresenter() {

    }

    void setStudentsView(StudentsView studentsView) {
        this.studentsView = studentsView;
    }
}
