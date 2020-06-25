package com.example.java_mvvm.core.dager;

import com.example.java_mvvm.core.ViewModel.BaseViewModel;
import com.example.java_mvvm.core.component.UserComponent;
import com.example.java_mvvm.core.dager.Inject.BaseViewModelInject;
import com.example.java_mvvm.core.dager.Inject.RepositoryInject;
import com.example.java_mvvm.core.dager.provider.ProviderApiServiceFactory;
import com.example.java_mvvm.core.dager.provider.ProviderRetrofitFactory;
import com.example.java_mvvm.core.netWork.ApiInterface;
import com.example.java_mvvm.core.netWork.ApiModule;
import com.example.java_mvvm.core.repository.Repository;

import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class DaggerUserComponent implements UserComponent {

    private MembersInjector<BaseViewModel> homeViewModelMembersInjector;

    private MembersInjector<Repository> repositoryMembersInjector;

    private DaggerUserComponent(Builder builder) {
        assert builder != null;
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Builder builder) {
        Provider<Retrofit> retrofitProvider = DoubleCheck.provider(ProviderRetrofitFactory.create(builder.apiModule));

        Provider<ApiInterface> apiServiceProvider = DoubleCheck.provider(
                ProviderApiServiceFactory.create(
                        builder.apiModule, retrofitProvider));

        this.homeViewModelMembersInjector =
                BaseViewModelInject.create(apiServiceProvider);

        this.repositoryMembersInjector =
                RepositoryInject.create(apiServiceProvider);
    }

    @Override
    public void inject(BaseViewModel baseViewModel) {
        homeViewModelMembersInjector.injectMembers(baseViewModel);
    }

    @Override
    public void inject(Repository repository) {
        repositoryMembersInjector.injectMembers(repository);
    }

    public static final class Builder {
        private ApiModule apiModule;

        private Builder() {}

        public UserComponent build() {
            if (apiModule == null) {
                this.apiModule = new ApiModule();
            }
            return new DaggerUserComponent(this);
        }

        public Builder userModule(ApiModule apiModule) {
            this.apiModule = Preconditions.checkNotNull(apiModule);
            return this;
        }
    }
}
