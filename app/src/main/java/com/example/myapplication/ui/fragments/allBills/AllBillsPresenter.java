package com.example.myapplication.ui.fragments.allBills;


import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;

import javax.inject.Inject;

public class AllBillsPresenter implements AllBillsContract.Presenter {

    @NonNull
    private AllBillsContract.View mView;

    @Inject
    DatabaseHelper databaseHelper;

    AllBillsPresenter(@NonNull AllBillsContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void loadBills() {
        Log.e("xd", "load");
        mView.showBills(databaseHelper.getAllBills());
    }

}
