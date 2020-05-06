package com.example.myapplication.ui.fragments.allBills;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private AllBillsContract.Presenter mPresenter;

    @Override
    public @Nullable
    View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_bills, container, false);
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

     void initializeTextView() {
        mTxtvBillName = getView().findViewById(R.id.billNameDetails);
        mTxtvBillStatus = getView().findViewById(R.id.BillStatusDetails);
        mTxtvBillPrice = getView().findViewById(R.id.BillPriceDetails);
    }

    @SuppressLint("SetTextI18n")
    public static void setBillDetails(String BillName, String BillStatus, int BillPrize) {
        mTxtvBillName.setText(BillName);
        mTxtvBillStatus.setText(BillStatus);
        mTxtvBillPrice.setText(Integer.toString(BillPrize) + "zł");

    }

    @Override
    public void showBills(@NonNull List<Bill> bill) {
        mAdapter.submitList(bill);
    }
}
