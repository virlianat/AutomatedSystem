package com.virliana.automatedsystem.app.database;

import android.arch.persistence.room.ColumnInfo;

public class AgeRange {
    @ColumnInfo(name = "age_from")
    private int ageFrom;
    @ColumnInfo(name = "age_to")
    private int ageTo;

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public AgeRange(int ageFrom, int ageTo) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
    }
}
