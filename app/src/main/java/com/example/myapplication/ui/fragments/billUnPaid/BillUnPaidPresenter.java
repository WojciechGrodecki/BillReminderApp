package com.example.myapplication.ui.fragments.billUnPaid;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.ui.fragments.allBills.AllBillsContract;

import java.util.List;

import javax.inject.Inject;

public class BillUnPaidPresenter implements BillUnPaidContract.Presenter {

    @NonNull
    private BillUnPaidContract.View mView;

    BillUnPaidPresenter(@NonNull BillUnPaidContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }

    @Inject
    DatabaseHelper databaseHelper;

    @Override
    public void loadBills() {
        Log.e("xd", "load");
        mView.showBills(databaseHelper.getAllBills());
    }
}