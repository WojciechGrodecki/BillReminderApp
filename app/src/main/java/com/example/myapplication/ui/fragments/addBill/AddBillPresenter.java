package com.example.myapplication.ui.fragments.addBill;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;


public class AddBillPresenter implements AddBillContract.Presenter {

    @NonNull
    private AddBillContract.View mView;

    AddBillPresenter(@NonNull AddBillContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }
}