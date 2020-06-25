package com.example.java_mvvm.core.repository;

import com.example.java_mvvm.core.application.App;
import com.example.java_mvvm.core.netWork.ApiInterface;

import javax.inject.Inject;

public class Repository implements RepositoryContract {

    @Inject
    public
    ApiInterface apIinterface;

    public Repository() {
        (App.INSTANCE).getUserComponent().inject(this);
    }
}
