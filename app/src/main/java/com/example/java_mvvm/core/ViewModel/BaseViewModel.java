package com.example.java_mvvm.core.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.java_mvvm.core.application.App;
import com.example.java_mvvm.core.netWork.ApiInterface;

import javax.inject.Inject;

public abstract class BaseViewModel extends ViewModel {

    @Inject
    public
    ApiInterface apIinterface;

    public BaseViewModel() {
        (App.INSTANCE).getUserComponent().inject(this);
    }
}
