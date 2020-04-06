package com.example.myapplication.ui.activity.splash;

public interface SplashScreenContract {


    interface Presenter {
        void startActivityTimeOut();

    }

    interface View {
        void startMainActivity();

    }
}