package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student> getAll();

    @Query("SELECT * FROM student WHERE student_id IN (:userIds)")
    List<Student> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(Student... users);

    @Delete
    void delete(Student user);
}
