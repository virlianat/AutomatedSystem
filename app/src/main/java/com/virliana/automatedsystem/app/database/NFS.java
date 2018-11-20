package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Ignore;

public class NFS {
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "fathers_name")
    private String fathersName;
    @ColumnInfo(name = "surname")
    private String surname;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Ignore
    public NFS(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public NFS(String firstName, String fathersName, String surname) {
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.surname = surname;
    }

    @Override
    public String toString() {
        if (fathersName == null) {
            return firstName + " " + surname;
        } else {
            return firstName + " " + fathersName + " " + surname;
        }
    }
}
