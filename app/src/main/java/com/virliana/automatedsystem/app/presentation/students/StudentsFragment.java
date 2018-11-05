package com.virliana.automatedsystem.app.presentation.students;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

public class StudentsFragment extends Fragment implements StudentsView {
    public static final String TAG = "StudentsFragment";
    @Inject
    StudentsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentsActivity studentsActivity = (StudentsActivity) getActivity();
        StudentsComponent studentsComponent = studentsActivity.getDependencies();
        studentsComponent.inject(this);
    }

}
