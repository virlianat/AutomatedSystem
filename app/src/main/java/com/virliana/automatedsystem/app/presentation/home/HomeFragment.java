package com.virliana.automatedsystem.app.presentation.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.virliana.automatedsystem.R;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomeFragment extends Fragment implements HomeView {
    public static final String TAG = "HomeFragment";
    @Inject
    HomePresenter presenter;

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
}
