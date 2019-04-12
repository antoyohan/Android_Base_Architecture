package com.example.ando.android_base_architecture.ui.recycler_view.view_holders;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.ando.android_base_architecture.R;
import com.example.ando.android_base_architecture.models.Employee;
import com.example.ando.android_base_architecture.ui.adapters.ListRecyclerViewAdapter;
import com.example.ando.android_base_architecture.ui.recycler_view.common.HorizontalSpaceItemDecoration;
import com.example.ando.android_base_architecture.ui.recycler_view.common.RecyclerViewType;
import com.example.ando.android_base_architecture.ui.recycler_view.view_item.BaseViewItem;

import java.util.ArrayList;
import java.util.List;

public class LinearTrayViewHolder extends BaseViewHolder {
    private final TextView mTitleView;
    private RecyclerView mHorizontalRecyclerView;
    private ConstraintLayout mParent;
    private View mBottomDivider, mTopDivider;

    public LinearTrayViewHolder(@NonNull View itemView, int type) {
        super(itemView, type);
        mHorizontalRecyclerView = itemView.findViewById(R.id.linear_tray_list);
        mTitleView = itemView.findViewById(R.id.tray_title);
        mParent = itemView.findViewById(R.id.parent);
        mTopDivider = itemView.findViewById(R.id.divider);
        mBottomDivider = itemView.findViewById(R.id.bottom_divider);
        HorizontalSpaceItemDecoration dividerItemDecoration = new HorizontalSpaceItemDecoration(10);
        mHorizontalRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    public static int getLayout() {
        return R.layout.linear_tray_item;
    }

    @Override
    public void setData(BaseViewItem item) {
        // add a divider after each item for more clarity
        mTitleView.setText(item.getTitle());
        ListRecyclerViewAdapter adapter = new ListRecyclerViewAdapter(item.getItems());
        if (item.getSubLayoutType() == RecyclerViewType.STAGGERED_HORIZONTAL_GRID_ITEM) {
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            mHorizontalRecyclerView.setLayoutManager(layoutManager);

            mTopDivider.setVisibility(View.GONE);
            mBottomDivider.setVisibility(View.INVISIBLE);
        } else {
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(mHorizontalRecyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            mHorizontalRecyclerView.setLayoutManager(horizontalLayoutManager);

            mParent.setBackground(mParent.getContext().getDrawable(android.R.color.transparent));
            mTopDivider.setVisibility(View.VISIBLE);
            mBottomDivider.setVisibility(View.VISIBLE);
        }
        mHorizontalRecyclerView.setAdapter(adapter);
    }

    private List<BaseViewItem> getEmloyeeList() {
        List<BaseViewItem> contentList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            contentList.add(new Employee("Anto yohan", "Employee Id : DO-754", RecyclerViewType.MOVIE_POSTER_TYPE_1));
            contentList.add(new Employee("Sarath KN", "Employee Id : DO-264", RecyclerViewType.MOVIE_POSTER_TYPE_1));
            contentList.add(new Employee("Sonal BK ", "Employee Id : DO-986", RecyclerViewType.MOVIE_POSTER_TYPE_1));
            contentList.add(new Employee("Raghavendra Kamath ", "Employee Id : DO-963", RecyclerViewType.MOVIE_POSTER_TYPE_1));
            contentList.add(new Employee("Sreeram k", "Employee Id : DO-988", RecyclerViewType.MOVIE_POSTER_TYPE_1));
            contentList.add(new Employee("Naveen Krishna", "Employee Id : DO-132", RecyclerViewType.MOVIE_POSTER_TYPE_1));
            contentList.add(new Employee("Shajeer Ahmed", "Employee Id : DO-96", RecyclerViewType.MOVIE_POSTER_TYPE_1));
            contentList.add(new Employee("Vinod Kumar", "Employee Id : DO-451", RecyclerViewType.MOVIE_POSTER_TYPE_1));
            contentList.add(new Employee("Akshay Bhat", "Employee Id : DO-852", RecyclerViewType.MOVIE_POSTER_TYPE_1));
        }
        return contentList;
    }
}
