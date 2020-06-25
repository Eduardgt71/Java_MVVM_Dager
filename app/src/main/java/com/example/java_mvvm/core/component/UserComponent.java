package com.example.java_mvvm.core.component;


import com.example.java_mvvm.core.ViewModel.BaseViewModel;
import com.example.java_mvvm.core.netWork.ApiModule;
import com.example.java_mvvm.core.repository.Repository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface UserComponent {
    void inject(BaseViewModel homeViewModel);

    void inject(Repository repository);
}
