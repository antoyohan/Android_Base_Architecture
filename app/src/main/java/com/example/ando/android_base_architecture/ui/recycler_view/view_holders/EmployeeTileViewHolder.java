package com.example.ando.android_base_architecture.ui.recycler_view.view_holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.models.Employee;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

public class EmployeeTileViewHolder extends BaseViewHolder {
    private TextView mTitle;
    private TextView mSubTitle;

    public EmployeeTileViewHolder(@NonNull View itemView, int type) {
        super(itemView, type);
        mTitle = itemView.findViewById(R.id.title);
        mSubTitle = itemView.findViewById(R.id.sub_title);
    }

    public static int getLayout() {
        return R.layout.employee_list_item;
    }

    @Override
    public void setData(BaseViewItem item) {
        Employee data = (Employee)item;
        mTitle.setText(data.getmTitle());
        mSubTitle.setText(data.getmSubTitle());
    }
}
