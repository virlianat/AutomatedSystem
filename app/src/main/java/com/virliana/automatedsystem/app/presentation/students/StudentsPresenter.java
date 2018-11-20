package com.virliana.automatedsystem.app.presentation.students;

import android.os.Handler;

import com.virliana.automatedsystem.app.database.AppDatabase;
import com.virliana.automatedsystem.app.database.NFS;
import com.virliana.automatedsystem.app.database.Student;
import com.virliana.automatedsystem.app.database.StudentDao;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

public class StudentsPresenter {

    private StudentsView studentsView;
    private Thread thread;
    private Handler mainHandler;
    private AppDatabase database;

    @Inject
    StudentsPresenter(AppDatabase database) {
        this.mainHandler = new Handler();
        this.database = database;
    }

    void setStudentsView(StudentsView studentsView) {
        this.studentsView = studentsView;

    }

    void fillDatabase() {
        thread = new Thread() {
            @Override
            public void run() {
                StudentDao studentDao = database.studentDao();
                Calendar rightNow = Calendar.getInstance();
                rightNow.set(1998, 8, 31);
                Student student = new Student(1, new NFS("Virliana", "Tymkiv"), rightNow.getTime(), "test@test.com", "0667844558", Calendar.getInstance().getTime());
                studentDao.insert(student);
            }
        };
        thread.start();
    }

    void getStudentsFromDB() {
        thread = new Thread() {
            @Override
            public void run() {
                StudentDao studentDao = database.studentDao();
                List<Student> students = studentDao.getAll();
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        studentsView.showEvents(students);

                    }
                });
            }
        };
        thread.start();
    }

}
