package com.example.myapplication.ui.fragments.billUnPaid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.db.model.Bill;
import com.example.myapplication.ui.base.BaseFragment;
import com.example.myapplication.ui.fragments.allBills.recycler.BillListAdapter;

import java.util.List;

public class BillUnPaidFragment extends BaseFragment implements BillUnPaidContract.View {
    BillListAdapter mAdapter;
    RecyclerView mRecycler;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private BillUnPaidContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_bill_unpaid,container,false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycler = getView().findViewById(R.id.recyclerView);
        mAdapter = new BillListAdapter(getResources());
        mPresenter = new BillUnPaidPresenter(this);
        mPresenter.loadBills();
        setupRecycler();
    }

    private void setupRecycler() {
        mRecycler.setAdapter(mAdapter);
        Log.e("xd", "setupRecycler");

    }

    @Override
    public void showBills(List<Bill> bill) {
        mAdapter.submitList(bill);
    }
}
