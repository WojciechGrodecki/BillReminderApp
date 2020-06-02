package com.example.myapplication.ui.activity.mainActivity;

public interface MainActivityContract {


    interface Presenter {
        void unPaidBillListener();
    }

    interface View {
        void showNotify();
    }
}