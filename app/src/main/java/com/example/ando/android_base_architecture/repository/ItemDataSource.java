package com.example.ando.android_base_architecture.repository;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.ando.android_base_architecture.models.Employee;
import com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

import java.util.ArrayList;
import java.util.List;

public class ItemDataSource extends PageKeyedDataSource<Integer, BaseViewItem> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        callback.onResult(getEmloyeeList(), null, null);
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    private List<Employee> getEmloyeeList() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            employeeList.add(new Employee("Anto yohan", "Employee Id : DO-754", RecyclerViewType.EMPLOYEE_ITEM));
            employeeList.add(new Employee("Sarath KN", "Employee Id : DO-264", RecyclerViewType.EMPLOYEE_ITEM));
            employeeList.add(new Employee("Sonal BK ", "Employee Id : DO-986", RecyclerViewType.MOVIE_ITEM));
            employeeList.add(new Employee("Raghavendra Kamath ", "Employee Id : DO-963", RecyclerViewType.EMPLOYEE_ITEM));
            employeeList.add(new Employee("Sreeram k", "Employee Id : DO-988", RecyclerViewType.MOVIE_ITEM));
            employeeList.add(new Employee("Naveen Krishna", "Employee Id : DO-132", RecyclerViewType.EMPLOYEE_ITEM));
            employeeList.add(new Employee("Shajeer Ahmed", "Employee Id : DO-96", RecyclerViewType.EMPLOYEE_ITEM));
            employeeList.add(new Employee("Vinod Kumar", "Employee Id : DO-451", RecyclerViewType.MOVIE_ITEM));
            employeeList.add(new Employee("Akshay Bhat", "Employee Id : DO-852", RecyclerViewType.EMPLOYEE_ITEM));
        }
        return employeeList;
    }
}
