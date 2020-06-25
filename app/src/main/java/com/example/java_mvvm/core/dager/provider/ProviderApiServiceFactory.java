package com.example.java_mvvm.core.dager.provider;

import com.example.java_mvvm.core.netWork.ApiInterface;
import com.example.java_mvvm.core.netWork.ApiModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class ProviderApiServiceFactory implements Factory<ApiInterface> {
    private final ApiModule module;

    private final Provider<Retrofit> retrofitProvider;


    public static Factory<ApiInterface> create(
            ApiModule module, Provider<Retrofit> retrofitProvider) {
        return new ProviderApiServiceFactory(module, retrofitProvider);
    }

    public ProviderApiServiceFactory(
            ApiModule module, Provider<Retrofit> retrofitProvider) {
        assert module != null;
        this.module = module;
        assert retrofitProvider != null;
        this.retrofitProvider = retrofitProvider;
    }

    @Override
    public ApiInterface get() {
        return Preconditions.checkNotNull(
                module.providerApiService(retrofitProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
