package com.virliana.automatedsystem.app.presentation.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.presentation.students.StudentsActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment implements HomeView {
    public static final String TAG = "HomeFragment";
    @Inject
    HomePresenter presenter;

    @BindView(R.id.btn_students)
    Button studentsButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeActivity homeActivity = (HomeActivity) getActivity();
        HomeComponent homeComponent = homeActivity.getDependencies();
        homeComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setHomeView(this);
    }

    @Override
    public void showError(String error) {
        //tbd
    }

    @OnClick(R.id.btn_students)
    void onStudentsButtonClick() {
        StudentsActivity.startFrom(getActivity());
    }
}
