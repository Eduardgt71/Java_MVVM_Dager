package com.example.java_mvvm.core.application;

import android.app.Application;

import com.example.java_mvvm.core.component.UserComponent;
import com.example.java_mvvm.core.dager.DaggerUserComponent;
import com.example.java_mvvm.core.netWork.ApiModule;

public class App extends Application {

    private UserComponent userComponent;
    public static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        userComponent = DaggerUserComponent.builder().userModule(new ApiModule()).build();

    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
