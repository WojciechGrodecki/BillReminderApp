package com.example.myapplication.ui.fragments.allBills;


import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.db.model.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class AllBillsPresenter implements AllBillsContract.Presenter {
    private static final int TASK_COUNT = 20;

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
        if (databaseHelper.isEmpty()) {
            Log.e("xd", "empty");
            databaseHelper.insertBills(createRandomBills());
        }
        mView.showBills(databaseHelper.getAllBills());
    }

    @NonNull
    private List<Bill> createRandomBills() {
        List<Bill> bills = new ArrayList<>();
        for (int i = 0; i < TASK_COUNT; ++i) {
            Bill bill = new Bill();
            bill.setBillName(String.format(Locale.getDefault(), "Example bill number : %d", i + 1));
            bill.setStatus("Bill Unpaid");
            bills.add(bill);
        }

        return bills;
    }
}
