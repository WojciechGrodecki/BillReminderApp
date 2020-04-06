package com.example.myapplication.ui.activity.splash;

import android.os.Handler;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;


public class SplashScreenPresenter implements SplashScreenContract.Presenter {
 private static final int DELAY = 500;
    @NonNull
    private SplashScreenContract.View mView;

    SplashScreenPresenter(@NonNull SplashScreenContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void startActivityTimeOut() {
        Handler handler = new Handler();
        handler.postDelayed(() -> mView.startMainActivity(), DELAY);
    }
}