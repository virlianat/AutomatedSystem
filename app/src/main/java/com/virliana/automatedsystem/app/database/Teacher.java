package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

@Entity(tableName = "teacher")
public class Teacher {
    @PrimaryKey
    private int teacher_id;

    @Embedded
    private NFS nfs;

    @ColumnInfo(name = "last_changed")
    private LocalDateTime lastChanged;

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public NFS getNfs() {
        return nfs;
    }

    public void setNfs(NFS nfs) {
        this.nfs = nfs;
    }

    public LocalDateTime getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(LocalDateTime lastChanged) {
        this.lastChanged = lastChanged;
    }

    public Teacher(int teacher_id, NFS nfs, LocalDateTime lastChanged) {
        this.teacher_id = teacher_id;
        this.nfs = nfs;
        this.lastChanged = lastChanged;
    }
}
