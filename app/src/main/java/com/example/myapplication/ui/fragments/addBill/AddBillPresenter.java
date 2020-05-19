package com.example.myapplication.ui.fragments.addBill;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.db.model.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.inject.Inject;


public class AddBillPresenter implements AddBillContract.Presenter {

    @NonNull
    private AddBillContract.View mView;

    @Inject
    DatabaseHelper databaseHelper;

    AddBillPresenter(@NonNull AddBillContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void addNewBill(@NonNull String BillName, @NonNull String BillStatus, int BillPrize, String BillDate, String BillCycle) {
        databaseHelper.insertBills(createBills(BillName,BillStatus,BillPrize,BillDate,BillCycle));
        Log.e("xd",BillName + "  " +BillStatus + " " + BillPrize);
    }

    @NonNull
    private List<Bill> createBills(String BillName, String BillStatus, int BillPrize, String BillDate, String Billcycle) {
        List<Bill> bills = new ArrayList<>();
            Bill bill = new Bill();
            bill.setBillName(BillName);
            bill.setBillPrice(BillPrize);
            bill.setStatus(BillStatus);
            bill.setBillDate(BillDate);
            bill.setRepeat(Billcycle);
            bills.add(bill);
        return bills;
    }

}