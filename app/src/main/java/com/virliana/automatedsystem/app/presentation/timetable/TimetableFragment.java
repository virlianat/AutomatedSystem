package com.virliana.automatedsystem.app.presentation.timetable;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.database.NFS;
import com.virliana.automatedsystem.app.database.Student;
import com.virliana.automatedsystem.app.presentation.students.StudentsPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimetableFragment extends Fragment implements TimetableView {
    @Inject
    StudentsPresenter presenter;

    @BindView(R.id.tv_hip_hop)
    TextView showStudents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimetableActivity timetableActivity = (TimetableActivity) getActivity();
        TimetableComponent timetableComponent = timetableActivity.getDependencies();
        timetableComponent.inject(this);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_timetable, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //presenter.setTimetableView(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.tv_hip_hop)
    void onShowStudentsClick() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, new NFS("Iryna", "Kudinova"), "25/05/1999", "test@test.com", "5544554", Calendar.getInstance().getTime()));
        students.add(new Student(2, new NFS("Vladislav", "Moroz"), "30/07/1998", "vmor@test.com", "505522552", Calendar.getInstance().getTime()));
        students.add(new Student(3, new NFS("Victoria", "Savka"), "31/08/1998", "testvic@test.com", "556655556", Calendar.getInstance().getTime()));
        TimetableDialogFragment dialogFragment = new TimetableDialogFragment();
        dialogFragment.setTargetFragment(this, 0);
        dialogFragment.show(getFragmentManager(), "timetableDialog");
        Log.i("Tag", "onAddStudentClick: ");
    }
}
