package com.example.myapplication.ui.fragments.billDetails;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;

public class BillDetailsPresenter implements BillDetailsContract.Presenter {

    @NonNull
    private BillDetailsContract.View mView;

    BillDetailsPresenter(@NonNull BillDetailsContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }
}