package com.example.myapplication;


import android.app.Application;

import com.example.myapplication.di.ApplicationComponent;
import com.example.myapplication.di.ApplicationModule;
import com.example.myapplication.di.DaggerApplicationComponent;

public class BillReminderApplication extends Application {
    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getApplicationComponent(){return sApplicationComponent;}
}
