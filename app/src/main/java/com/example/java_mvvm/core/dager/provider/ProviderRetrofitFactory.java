package com.example.java_mvvm.core.dager.provider;

import com.example.java_mvvm.core.netWork.ApiModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

public final class ProviderRetrofitFactory implements Factory<Retrofit> {
    private final ApiModule module;



    public static Factory<Retrofit> create(ApiModule module) {
        return new ProviderRetrofitFactory(module);
    }

    public ProviderRetrofitFactory(ApiModule module) {
        assert module != null;
        this.module = module;
    }

    @Override
    public Retrofit get() {
        return Preconditions.checkNotNull(
                module.providerRetrofit(), "Cannot return null from a non-@Nullable @Provides method");
    }
}