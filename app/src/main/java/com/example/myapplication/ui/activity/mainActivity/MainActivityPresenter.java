package com.example.myapplication.ui.activity.mainActivity;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    @NonNull
    private MainActivityContract.View mView;

    MainActivityPresenter(@NonNull MainActivityContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }

}