package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import java.time.LocalDateTime;

@Entity(tableName = "visiting",
        foreignKeys = {@ForeignKey(entity = Studio.class,
                parentColumns = "studio_id",
                childColumns = "studio_id"),
                @ForeignKey(entity = Student.class,
                        parentColumns = "student_id",
                        childColumns = "student_id")},
        primaryKeys = {"studio_id", "student_id", "date"})
public class Visiting {
    int studio_id;
    int student_id;
    LocalDateTime date;

    public Visiting(int studio_id, int student_id, LocalDateTime date) {
        this.studio_id = studio_id;
        this.student_id = student_id;
        this.date = date;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
