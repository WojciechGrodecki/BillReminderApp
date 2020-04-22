package com.example.myapplication.ui.fragments.billPaid;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;

public class BillPaidPresenter implements BillPaidContract.Presenter {

    @NonNull
    private BillPaidContract.View mView;

    BillPaidPresenter(@NonNull BillPaidContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }


}