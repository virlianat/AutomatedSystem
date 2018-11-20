package com.virliana.automatedsystem.app.presentation.students;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrogomez.renderers.RVRendererAdapter;
import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.OnItemClickListener;
import com.virliana.automatedsystem.app.StudentsRenderer;
import com.virliana.automatedsystem.app.database.Student;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentsFragment extends Fragment implements StudentsView, OnItemClickListener {
    public static final String TAG = "StudentsFragment";
    @Inject
    StudentsPresenter presenter;

    private RVRendererAdapter<Student> adapterStudents;

    @BindView(R.id.rv_students_list)
    RecyclerView studentsRV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentsActivity studentsActivity = (StudentsActivity) getActivity();
        StudentsComponent studentsComponent = studentsActivity.getDependencies();
        studentsComponent.inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_students, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setStudentsView(this);
        // presenter.fillDatabase();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterStudents = StudentsRenderer.createAdapter(this);
        studentsRV.setAdapter(adapterStudents);
        presenter.getStudentsFromDB();
    }


    @Override
    public void showEvents(List<Student> studentList) {
        adapterStudents.clear();
        if (studentList.isEmpty()) {
            //tbd
        } else {
            adapterStudents.addAll(studentList);
        }
        adapterStudents.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(Object item) {
        //tbd
    }


}
