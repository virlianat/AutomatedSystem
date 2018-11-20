package com.virliana.automatedsystem.app;

import com.virliana.automatedsystem.app.presentation.home.HomeComponent;
import com.virliana.automatedsystem.app.presentation.home.HomeModule;
import com.virliana.automatedsystem.app.presentation.students.StudentsComponent;
import com.virliana.automatedsystem.app.presentation.students.StudentsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, StorageModule.class})
public interface AppComponent {
    HomeComponent createHomeComponent(HomeModule homeModule);
    StudentsComponent createStudentsComponent(StudentsModule studentsModule);
}
