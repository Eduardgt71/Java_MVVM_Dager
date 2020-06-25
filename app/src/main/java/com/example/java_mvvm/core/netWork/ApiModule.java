package com.example.java_mvvm.core.netWork;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {
    public static final String URL = "https://api.github.com";

    @Provides
    @Singleton
    public Retrofit providerRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ApiInterface providerApiService(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}
