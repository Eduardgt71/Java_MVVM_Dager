package com.example.java_mvvm.ui;

import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.java_mvvm.R;
import com.example.java_mvvm.core.ViewModel.HomeViewModel;
import com.example.java_mvvm.core.model.response.User;
import com.example.java_mvvm.ui.adapter.ListUserAdapter;
import com.example.java_mvvm.ui.adapter.OnItemlick;
import com.example.java_mvvm.ui.base.BaseFragment;

import java.util.List;

public class HomeFragment extends BaseFragment {

    private HomeViewModel viewModel;
    private RecyclerView recyclerView;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void initView(View view) {
        viewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);

        TextView start = view.findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.start();
            }
        });

        recyclerView = view.findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void bindingView() {
        viewModel.getList().observe(getActivity(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if (users != null) {
                    ListUserAdapter adapter = new ListUserAdapter(users, new OnItemlick() {
                        @Override
                        public void onItemClick(int position) {

                        }
                    });

                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }
}
