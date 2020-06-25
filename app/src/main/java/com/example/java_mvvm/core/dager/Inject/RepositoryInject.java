package com.example.java_mvvm.core.dager.Inject;

import com.example.java_mvvm.core.ViewModel.BaseViewModel;
import com.example.java_mvvm.core.netWork.ApiInterface;
import com.example.java_mvvm.core.repository.Repository;

import javax.inject.Provider;

import dagger.MembersInjector;

public class RepositoryInject implements MembersInjector<Repository> {

    private final Provider<ApiInterface> apIinterfaceProvider;

    public RepositoryInject(Provider<ApiInterface> apIinterfaceProvider) {
        assert apIinterfaceProvider != null;
        this.apIinterfaceProvider = apIinterfaceProvider;
    }

    public static MembersInjector<Repository> create(Provider<ApiInterface> apIinterfaceProvider) {
        return new RepositoryInject(apIinterfaceProvider);
    }

    @Override
    public void injectMembers(Repository instance) {
        if (instance == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        instance.apIinterface = apIinterfaceProvider.get();
    }

    public static void injectApIinterface(
            Repository instance, Provider<ApiInterface> apIinterfaceProvider) {
        instance.apIinterface = apIinterfaceProvider.get();
    }
}
