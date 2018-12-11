package com.virliana.automatedsystem.app.presentation.students;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pedrogomez.renderers.RVRendererAdapter;
import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.OnItemClickListener;
import com.virliana.automatedsystem.app.StudentsRenderer;
import com.virliana.automatedsystem.app.database.Student;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudentsFragment extends Fragment implements StudentsView, OnItemClickListener, StudentsDialogFragment.StudentsDialogListener {
    public static final String TAG = "StudentsFragment";
    @Inject
    StudentsPresenter presenter;
    public static StudentsFragment instance;
    private RVRendererAdapter<Student> adapterStudents;

    @BindView(R.id.rv_students_list)
    RecyclerView studentsRV;
    @BindView(R.id.iv_add_student)
    ImageView addStudent;
    public static SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentsActivity studentsActivity = (StudentsActivity) getActivity();
        StudentsComponent studentsComponent = studentsActivity.getDependencies();
        studentsComponent.inject(this);
        instance = this;
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

    }

    public static StudentsFragment getInstance() {
        return instance;
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

    @OnClick(R.id.iv_add_student)
    public void onAddStudentClick() {
        StudentsDialogFragment studentsDialogFragment = new StudentsDialogFragment();
        studentsDialogFragment.setTargetFragment(this, 0);
        studentsDialogFragment.show(getFragmentManager(), "studentDialog");
        Log.i(TAG, "onAddStudentClick: ");
    }

    @Override
    public void createStudent(String nfs, String dateOfBirth, String email, String phone) {
        Log.i(TAG, "createStudent: ");
        int id = 1;
        if (!sharedPref.contains("first_start")) {
            Log.i(TAG, "createStudent: first_start");
            presenter.fillDatabase(id, nfs, dateOfBirth, email, phone);
            editor.putInt("first_start", ++id);
            editor.commit();
        } else {
            Log.i(TAG, "createStudent: " + sharedPref.getInt("first_start", 0));
            id = sharedPref.getInt("first_start", 0);
            presenter.fillDatabase(id, nfs, dateOfBirth, email, phone);
            editor.putInt("first_start", ++id);
            editor.commit();
        }

    }



}
