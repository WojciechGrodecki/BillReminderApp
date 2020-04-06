package com.example.myapplication.di;

import com.example.myapplication.ui.activity.mainActivity.MainActivityPresenter;
import com.example.myapplication.ui.activity.splash.SplashScreenPresenter;
import com.example.myapplication.ui.fragments.addBill.AddBillPresenter;
import com.example.myapplication.ui.fragments.allBills.AllBillsPresenter;
import com.example.myapplication.ui.fragments.billDetails.BillDetailsPresenter;
import com.example.myapplication.ui.fragments.billPaid.BillPaidPresenter;
import com.example.myapplication.ui.fragments.billUnPaid.BillUnPaidPresenter;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject (SplashScreenPresenter presenter);
    void inject (MainActivityPresenter presenter);
    void inject (AddBillPresenter presenter);
    void inject (AllBillsPresenter presenter);
    void inject (BillDetailsPresenter presenter);
    void inject (BillPaidPresenter presenter);
    void inject (BillUnPaidPresenter presenter);
}