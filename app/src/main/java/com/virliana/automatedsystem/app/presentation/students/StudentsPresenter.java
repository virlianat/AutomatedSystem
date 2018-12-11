package com.virliana.automatedsystem.app.presentation.students;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;

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

    void fillDatabase(int id, String nfs, String date, String email, String number) {
        thread = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                StudentDao studentDao = database.studentDao();
                String receivedEmail = email;
                Integer receivedNumber = new Integer(number);
                int receivedId = id;
                if (receivedEmail == null) {
                    receivedEmail = "unknown";
                }
                if (receivedNumber == null) {
                    receivedNumber = 0000;
                }
                Log.i("Tag", "run: " + nfs.substring(0, nfs.indexOf(" ")) + " " + nfs.substring(nfs.indexOf(" ") + 1));
                Student student = new Student(receivedId, new NFS(nfs.substring(0, nfs.indexOf(" ")), nfs.substring(nfs.indexOf(" ") + 1)), date, receivedEmail, receivedNumber.toString(), Calendar.getInstance().getTime());
                studentDao.insert(student);
                getStudentsFromDB();
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
                Log.i("Tag", "run: getstudentsfromdb");
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
