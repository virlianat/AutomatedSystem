package com.virliana.automatedsystem.app;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.virliana.automatedsystem.app.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {

    @Provides
    @Singleton
    AppDatabase createAppDatabase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, "databaseMaasai").build();
    }

}