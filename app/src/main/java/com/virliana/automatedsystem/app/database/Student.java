package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey
    private int student_id;

    @Embedded
    private String nfs;

    @ColumnInfo(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "phone_number")
    private String number;

    @ColumnInfo(name = "last_changed")
    private LocalDateTime lastChanged;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getNfs() {
        return nfs;
    }

    public void setNfs(String nfs) {
        this.nfs = nfs;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(LocalDateTime lastChanged) {
        this.lastChanged = lastChanged;
    }

    public Student(int student_id, String nfs, LocalDate dateOfBirth, String email, String number, LocalDateTime lastChanged) {
        this.student_id = student_id;
        this.nfs = nfs;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.number = number;
        this.lastChanged = lastChanged;
    }
}