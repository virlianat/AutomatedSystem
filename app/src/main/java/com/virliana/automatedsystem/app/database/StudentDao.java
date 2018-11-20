package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student> getAll();

    @Query("SELECT * FROM student WHERE student_id IN (:studentIds)")
    List<Student> loadAllByIds(int[] studentIds);

    @Insert
    void insertAll(Student... students);

    @Delete
    void delete(Student student);

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

}
