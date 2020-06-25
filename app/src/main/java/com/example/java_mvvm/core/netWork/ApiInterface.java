package com.example.java_mvvm.core.netWork;

import com.example.java_mvvm.core.model.response.User;
import com.example.java_mvvm.core.model.response.UserDetail;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiInterface {
    @GET("/users")
    Observable<List<User>> getListUser();
    @GET("/users/{login}")
    Observable<UserDetail> getUserDetail(@Path("login") String login);
}
