package com.example.ando.android_base_architecture.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.databinding.FragmentListBinding;
import com.example.ando.android_base_architecture.models.Employee;
import com.example.ando.android_base_architecture.ui.adapters.ListRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class Fragment_Recycler extends Fragment {
    private static String TAG = Fragment_Recycler.class.getSimpleName();

    private FragmentListBinding layoutBinding;

    @Inject
    public Fragment_Recycler() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        Log.d(TAG, "onCreateView: ");
        initViews();
        return layoutBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initViews() {
        Log.d(TAG, "initViews:");
        ListRecyclerViewAdapter adapter = new ListRecyclerViewAdapter(getEmloyeeList());
        layoutBinding.mainList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        layoutBinding.mainList.setAdapter(adapter);
    }

    private List<Employee> getEmloyeeList() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            employeeList.add(new Employee("My Name", " Details"));
        }
        return employeeList;
    }
}
