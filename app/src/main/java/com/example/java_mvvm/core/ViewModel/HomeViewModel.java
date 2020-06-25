package com.example.java_mvvm.core.ViewModel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.java_mvvm.core.application.App;
import com.example.java_mvvm.core.model.response.User;
import com.example.java_mvvm.core.repository.RepositoryContract;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class HomeViewModel extends BaseViewModel {

    @Inject
    public
    RepositoryContract repositoryContract;

    public HomeViewModel() {
        (App.INSTANCE).getUserComponent().inject(this);
    }

    private MutableLiveData<List<User>> list = new MutableLiveData<>();

    public void start() {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        Subscription subscription = apIinterface.getListUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("", "");
                    }

                    @Override
                    public void onNext(List<User> users) {
                        list.postValue(users);
                    }
                });
        compositeSubscription.add(subscription);
    }

    public MutableLiveData<List<User>> getList() {
        return list;
    }
}
