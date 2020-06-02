package com.example.myapplication.ui.fragments.allBills;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.db.model.Bill;
import com.example.myapplication.ui.base.BaseFragment;
import com.example.myapplication.ui.fragments.allBills.recycler.BillListAdapter;

import java.util.List;

public class AllBillsFragment extends BaseFragment
        implements AllBillsContract.View {
    BillListAdapter mAdapter;
    RecyclerView mRecycler;
    public static TextView mTxtvBillName;
    public static TextView mTxtvBillStatus;
    public static TextView mTxtvBillPrice;
    public static TextView mTxtvBillDate;
    public static TextView mTxTvBillCycle;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private AllBillsContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_all_bills, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecycler = getView().findViewById(R.id.recyclerView);
        mAdapter = new BillListAdapter(getResources());
        mPresenter = new AllBillsPresenter(this);
        mPresenter.loadBills();
        initializeTextView();
        setupRecycler();
    }

    private void setupRecycler() {
        mRecycler.setAdapter(mAdapter);
        Log.e("xd", "setupRecycler");
    }

    private void initializeTextView() {
        mTxtvBillName = getView().findViewById(R.id.billNameDetails);
        mTxtvBillStatus = getView().findViewById(R.id.billStatusDetails);
        mTxtvBillPrice = getView().findViewById(R.id.BillPriceDetails);
        mTxtvBillDate = getView().findViewById(R.id.billDate);
        mTxTvBillCycle = getView().findViewById(R.id.BillCycleDetails);
    }

    @SuppressLint("SetTextI18n")
    public static void setBillDetails(String BillName, String BillStatus, int billPrize, String billDate, String billCycle) {
        mTxtvBillName.setText("Name: " + BillName);
        mTxtvBillStatus.setText("Status: " + BillStatus);
        mTxtvBillPrice.setText("Value: " + Integer.toString(billPrize) + "zł");
        mTxtvBillDate.setText("Date: " + billDate);
        switch (billCycle) {
            case "2592000000":
                mTxTvBillCycle.setText("Cycle: Month");
                break;
            case "7776000000":
                mTxTvBillCycle.setText("Cycle: Quater");
                break;
            case "31104000000":
                mTxTvBillCycle.setText("Cycle: Year");
                break;
        }

    }

    @Override
    public void showBills(@NonNull List<Bill> bill) {
        mAdapter.submitList(bill);
    }
}
