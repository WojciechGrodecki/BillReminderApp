package com.example.myapplication.ui.fragments.billUnPaid;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.db.model.Bill;
import com.example.myapplication.ui.fragments.allBills.AllBillsFragment;
import com.example.myapplication.ui.fragments.billPaid.BillPaidFragment;

public class BillUnPaidListAdapter extends ListAdapter<Bill, BillUnPaidListAdapter.TaskItemViewHolder> {
    private Context context;

    public interface OnBillChangeListener {
        void onBillUpdate(@NonNull Bill bill);

    }

    private static final DiffUtil.ItemCallback<Bill> DIFF_UTIL = new DiffUtil.ItemCallback<Bill>() {
        @Override
        public boolean areItemsTheSame(@NonNull Bill oldItem, @NonNull Bill newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Bill oldItem, @NonNull Bill newItem) {
            return oldItem.getId() == newItem.getId();
        }
    };

    @NonNull
    private final Resources mResources;

    public BillUnPaidListAdapter(@NonNull Resources resources) {
        super(DIFF_UTIL);
        mResources = resources;
    }

    @Override
    @NonNull
    public TaskItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.bill_list_item, parent, false);
        return new TaskItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskItemViewHolder holder, int position) {
        Bill bill = getItem(position);
            holder.mTxtvID.setText(String.valueOf(bill.getId()));
            holder.mTxtName.setText("Bill Name: " + bill.getBillName());
            holder.linearLayout.setOnClickListener(v -> BillUnPaidFragment.setBillDetails(bill.getBillName(), bill.getBillPrice(), bill.getBillDate(), bill.getRepeat()));
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    class TaskItemViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private TextView mTxtvID;
        private TextView mTxtName;


        TaskItemViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.BillList);
            mTxtvID = itemView.findViewById(R.id.billID);
            mTxtName = itemView.findViewById(R.id.billName);
        }
    }
}
