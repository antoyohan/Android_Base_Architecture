package com.example.ando.android_base_architecture.ui.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.models.Employee;

import java.util.List;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.ListViewHolder> {

    List<Employee> mEmployeeList;

    public ListRecyclerViewAdapter(List<Employee> employeeList) {
        this.mEmployeeList = employeeList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.employee_list_item,
                viewGroup, false);
        return new ListViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        Employee employee = mEmployeeList.get(i);
        listViewHolder.mTitle.setText(employee.getmTitle());
        listViewHolder.mSubtitle.setText(employee.getmSubTitle());
    }

    @Override
    public int getItemCount() {
        return mEmployeeList.size();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mSubtitle;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mSubtitle = itemView.findViewById(R.id.sub_title);
        }
    }
}
