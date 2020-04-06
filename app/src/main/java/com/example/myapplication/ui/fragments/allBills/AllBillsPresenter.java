package com.example.myapplication.ui.fragments.allBills;


import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;

public class AllBillsPresenter implements AllBillsContract.Presenter {

    @NonNull
    private AllBillsContract.View mView;

    AllBillsPresenter(@NonNull AllBillsContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }
}