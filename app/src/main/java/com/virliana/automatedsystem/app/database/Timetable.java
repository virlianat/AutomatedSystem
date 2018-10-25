package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(tableName = "timetable",foreignKeys = @ForeignKey(entity = Studio.class,
        parentColumns = "studio_id",
        childColumns = "studio_id"))
public class Timetable {
    @PrimaryKey
    private int table_id;

    @ColumnInfo(name = "day")
    private LocalDate day;

    @ColumnInfo(name = "hour")
    private LocalTime hour;

    @ColumnInfo(name = "last_changed")
    private LocalDateTime lastChanged;

    @ColumnInfo(name = "studio_id")
    private int studioId;

    public Timetable(int table_id, LocalDate day, LocalTime hour, LocalDateTime lastChanged, int studioId) {
        this.table_id = table_id;
        this.day = day;
        this.hour = hour;
        this.lastChanged = lastChanged;
        this.studioId = studioId;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public LocalDateTime getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(LocalDateTime lastChanged) {
        this.lastChanged = lastChanged;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }
}
