package com.example.java_mvvm.core.dager.Inject;

import com.example.java_mvvm.core.ViewModel.BaseViewModel;
import com.example.java_mvvm.core.netWork.ApiInterface;

import javax.inject.Provider;

import dagger.MembersInjector;

public class BaseViewModelInject implements MembersInjector<BaseViewModel> {

    private final Provider<ApiInterface> apIinterfaceProvider;

    public BaseViewModelInject(Provider<ApiInterface> apIinterfaceProvider) {
        assert apIinterfaceProvider != null;
        this.apIinterfaceProvider = apIinterfaceProvider;
    }

    public static MembersInjector<BaseViewModel> create(Provider<ApiInterface> apIinterfaceProvider) {
        return new BaseViewModelInject(apIinterfaceProvider);
    }

    @Override
    public void injectMembers(BaseViewModel instance) {
        if (instance == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        instance.apIinterface = apIinterfaceProvider.get();
    }

    public static void injectApIinterface(
            BaseViewModel instance, Provider<ApiInterface> apIinterfaceProvider) {
        instance.apIinterface = apIinterfaceProvider.get();
    }
}