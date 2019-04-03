package com.example.ando.android_base_architecture.ui;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.databinding.FragmentListBinding;
import com.example.ando.android_base_architecture.models.Employee;
import com.example.ando.android_base_architecture.ui.adapters.ListRecyclerViewAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class Fragment_Recycler extends Fragment {
    private static String TAG = Fragment_Recycler.class.getSimpleName();

    private FragmentListBinding layoutBinding;
    private ShimmerFrameLayout mShimmerViewContainer;

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
        mShimmerViewContainer = layoutBinding.getRoot().findViewById(R.id.shimmer_view_container);

        new Handler().postDelayed(this::initViews, 3000);
        return layoutBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    private void initViews() {
        Log.d(TAG, "initViews:");
        ListRecyclerViewAdapter adapter = new ListRecyclerViewAdapter(getEmloyeeList());
        layoutBinding.mainList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        layoutBinding.mainList.setAdapter(adapter);
        layoutBinding.mainList.setVisibility(View.VISIBLE);
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
