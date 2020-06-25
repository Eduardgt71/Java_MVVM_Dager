package com.example.java_mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.java_mvvm.R;
import com.example.java_mvvm.core.ViewModel.BaseViewModel;
import com.example.java_mvvm.core.ViewModel.HomeViewModel;
import com.example.java_mvvm.core.application.App;
import com.example.java_mvvm.core.netWork.ApiInterface;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}