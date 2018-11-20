package com.virliana.automatedsystem.app.presentation.students;

import com.virliana.automatedsystem.app.database.Student;

import java.util.List;

public interface StudentsView {
    void showEvents(List<Student> studentList);
}
