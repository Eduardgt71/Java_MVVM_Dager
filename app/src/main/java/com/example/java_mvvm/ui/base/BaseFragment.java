package com.example.java_mvvm.ui.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public abstract class BaseFragment extends Fragment {

    public BaseFragment(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindingView();
        initViewModel();
        loadingObserve();
        exceptionObserve();

    }

    public NavController navController(Integer navHostFragment) {
        return Navigation.findNavController(requireActivity(), navHostFragment);
    }

    public void exceptionObserve() {
    }

    public void loadingObserve() {
    }

    public void initViewModel() {
    }

    public void bindingView() {
    }

    public void initView(View view) {
    }
}
