package com.example.myapplication.ui.activity.mainActivity;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.db.model.Bill;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class MainActivityPresenter implements MainActivityContract.Presenter {
String allBill;
    @Inject
    DatabaseHelper databaseHelper;

    @NonNull
    private MainActivityContract.View mView;

    MainActivityPresenter(@NonNull MainActivityContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }


    @Override
    public void unPaidBillListener() {
        String currentDate = new SimpleDateFormat("dd / MM / yyyy", Locale.getDefault()).format(new Date());
        databaseHelper.getAllBillsDate();
        String callendarDate;
        callendarDate = databaseHelper.getAllBillsDate().toString();
        Log.e("xdd","date: " +  callendarDate);
        Log.e("xdd","currentData: " +  currentDate);
    }
}