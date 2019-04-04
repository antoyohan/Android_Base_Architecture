package com.example.ando.android_base_architecture.ui;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.models.Employee;
import com.example.ando.android_base_architecture.ui.adapters.RecyclerListAdapter;
import com.example.ando.android_base_architecture.viewmodel.ItemViewModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment_Recycler extends Fragment implements LifecycleOwner {
    private static String TAG = Fragment_Recycler.class.getSimpleName();

    private ViewDataBinding layoutBinding;
    private ShimmerFrameLayout mShimmerViewContainer;
    private RecyclerView mRecyclerView;

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
        mShimmerViewContainer = layoutBinding.getRoot().findViewById(R.id.shimmer_view_container);
        mRecyclerView = layoutBinding.getRoot().findViewById(R.id.main_list);
        initViews();
        return layoutBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        //mShimmerViewContainer.startShimmerAnimation();
    }

    private void initViews() {
        Log.d(TAG, "initViews:");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        RecyclerListAdapter adapter = new RecyclerListAdapter();

        itemViewModel.itemPagedList.observe(this, pagedList -> {
            Log.d(TAG, "observe called " + pagedList.size());
            adapter.submitList(pagedList);
        });
        mRecyclerView.setAdapter(adapter);

        stopShimmerAnimation();
    }

    private void stopShimmerAnimation() {
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }

    private List<Employee> getEmloyeeList() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            employeeList.add(new Employee("Anto yohan", "Employee Id : DO-754"));
            employeeList.add(new Employee("Sarath KN", "Employee Id : DO-264"));
            employeeList.add(new Employee("Sonal BK ", "Employee Id : DO-986"));
            employeeList.add(new Employee("Raghavendra Kamath ", "Employee Id : DO-963"));
            employeeList.add(new Employee("Sreeram k", "Employee Id : DO-988"));
            employeeList.add(new Employee("Naveen Krishna", "Employee Id : DO-132"));
            employeeList.add(new Employee("Shajeer Ahmed", "Employee Id : DO-96"));
            employeeList.add(new Employee("Vinod Kumar", "Employee Id : DO-451"));
            employeeList.add(new Employee("Akshay Bhat", "Employee Id : DO-852"));
        }
        return employeeList;
    }
}
