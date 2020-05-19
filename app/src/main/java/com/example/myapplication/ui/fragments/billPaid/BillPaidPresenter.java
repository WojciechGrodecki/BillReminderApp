package com.example.myapplication.ui.fragments.billPaid;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.ui.fragments.allBills.AllBillsContract;

import javax.inject.Inject;

public class BillPaidPresenter implements BillPaidContract.Presenter {

    @NonNull
    private BillPaidContract.View mView;

    @Inject
    DatabaseHelper databaseHelper;

    BillPaidPresenter(@NonNull BillPaidContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }


    @Override
    public void loadBills() {
        Log.e("xd", "load");
        mView.showBills(databaseHelper.getAllBills());
    }

}