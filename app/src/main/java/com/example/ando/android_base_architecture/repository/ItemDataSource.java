package com.example.ando.android_base_architecture.repository;

import android.arch.paging.PageKeyedDataSource;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.ando.android_base_architecture.models.BaseResponse;
import com.example.ando.android_base_architecture.models.Employee;
import com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ItemDataSource extends PageKeyedDataSource<Integer, BaseViewItem> {
    private static final String TAG = ItemDataSource.class.getSimpleName();
    private final Context mContext;

    public ItemDataSource(Context context) {
        mContext = context;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        callback.onResult(readJsonFromAssets(), null, null);
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
            employeeList.add(new Employee("Anto yohan", "Employee Id : DO-754", RecyclerViewType.ACTOR_ITEM));
            employeeList.add(new Employee("Sarath KN", "Employee Id : DO-264", RecyclerViewType.LINEAR_TRAY));
            employeeList.add(new Employee("Sonal BK ", "Employee Id : DO-986", RecyclerViewType.EMOTICON_ITEM));
            employeeList.add(new Employee("Raghavendra Kamath ", "Employee Id : DO-963", RecyclerViewType.ACTOR_ITEM));
            employeeList.add(new Employee("Sreeram k", "Employee Id : DO-988", RecyclerViewType.EMOTICON_ITEM));
            employeeList.add(new Employee("Naveen Krishna", "Employee Id : DO-132", RecyclerViewType.ACTOR_ITEM));
            employeeList.add(new Employee("Shajeer Ahmed", "Employee Id : DO-96", RecyclerViewType.ACTOR_ITEM));
            employeeList.add(new Employee("Vinod Kumar", "Employee Id : DO-451", RecyclerViewType.EMOTICON_ITEM));
            employeeList.add(new Employee("Akshay Bhat", "Employee Id : DO-852", RecyclerViewType.ACTOR_ITEM));
        }
        return employeeList;
    }

    private List<BaseViewItem> readJsonFromAssets() {
        List<BaseViewItem> convertedList = new ArrayList<>();
        try {
            InputStream is = mContext.getAssets().open("HomeResponse.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            Log.i(TAG, "readJson: " + json.toLowerCase().toString());
            BaseResponse convertedObject = new Gson().fromJson(json, BaseResponse.class);
            convertedList.addAll(convertedObject.getDataList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return convertedList;
    }
}
