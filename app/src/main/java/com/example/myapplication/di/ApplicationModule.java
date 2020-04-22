package com.example.myapplication.di;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.db.impl.DatabaseHelperImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private BillReminderApplication mApplication;

    public ApplicationModule(@NonNull BillReminderApplication application) {
        mApplication = application;
    }

    @Provides
    Context providesContext() {
        return mApplication.getBaseContext();
    }

    @Provides
    DatabaseHelper providesDatabaseHelper(@NonNull Context context) {
        return DatabaseHelperImpl.getInstance(context);
    }
}
