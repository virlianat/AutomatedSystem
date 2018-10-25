package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

@Entity(tableName = "studio",foreignKeys = @ForeignKey(entity = Teacher.class,
        parentColumns = "teacher_id",
        childColumns = "teacher_id"))
public class Studio {

    @PrimaryKey
    private int studio_id;

    @ColumnInfo(name = "teacher_id")
    private int teacherId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "level")
    private String level;

    @ColumnInfo(name = "price")
    private Integer price;

    @ColumnInfo(name = "last_changed")
    private LocalDateTime lastChanged;

    @ColumnInfo(name = "hall")
    private String hall;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Embedded
    private AgeRange range;

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(LocalDateTime lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public AgeRange getRange() {
        return range;
    }

    public void setRange(AgeRange range) {
        this.range = range;
    }

    public Studio(int studio_id, String name, String level, Integer price, LocalDateTime lastChanged, String hall, AgeRange range,int teacherId) {
        this.studio_id = studio_id;
        this.name = name;
        this.level = level;
        this.price = price;
        this.lastChanged = lastChanged;
        this.hall = hall;
        this.range = range;
        this.teacherId=teacherId;
    }
}
