package com.example.myapplication.ui.fragments.billUnPaid;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;

public class BillUnPaidPresenter implements BillUnPaidContract.Presenter {

    @NonNull
    private BillUnPaidContract.View mView;

    BillUnPaidPresenter(@NonNull BillUnPaidContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }
}