package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey
    private int student_id;

    @Embedded
    private NFS nfs;

    @ColumnInfo(name = "date_of_birth")
    private String dateOfBirth;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "phone_number")
    private String number;

    @ColumnInfo(name = "last_changed")
    private Date lastChanged;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public NFS getNfs() {
        return nfs;
    }

    public void setNfs(NFS nfs) {
        this.nfs = nfs;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public Date getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }

    public Student(int student_id, NFS nfs, String dateOfBirth, String email, String number, Date lastChanged) {
        this.student_id = student_id;
        this.nfs = nfs;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.number = number;
        this.lastChanged = lastChanged;
    }
}