package com.example.myapplication.ui.activity.mainActivity;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;

import java.util.GregorianCalendar;

import javax.inject.Inject;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private String callendarDate;
    private String callendarDateTime;
    private long date;
    @Inject
    DatabaseHelper databaseHelper;

    @NonNull
    private MainActivityContract.View mView;

    MainActivityPresenter(@NonNull MainActivityContract.View view) {
        mView = view;
        BillReminderApplication.getApplicationComponent().inject(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void unPaidBillListener() {
        databaseHelper.getAllBillsDate();
        callendarDate = databaseHelper.getAllBillsDate().toString();
        callendarDateTime = databaseHelper.getAllBillsDateTime().toString();

        Log.e("xdd", "date From Callendar: " + callendarDate);
        Log.e("xdd", "date: " + callendarDateTime);
        separateCommand();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void separateCommand() {
        Log.e("xd", "non-separated date: " + callendarDateTime);
        String[] firstSplitString = callendarDateTime.split("\\[");
        for (String splited : firstSplitString) {
            String[] secondSplitString = splited.split("\\]");
            for (String secondSplited : secondSplitString) {
                String[] thirdSplitString = secondSplited.split(",");
                for (String thirdSplited : thirdSplitString) {
                    Log.e("xddd", "splitedThirs: " + thirdSplited);
                    compareData(thirdSplited);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void compareData(String dataFromDatabase) {
        Log.e("xddd", "data to Long:" + dataFromDatabase);
        long currentDateLong = GregorianCalendar.getInstance().getTimeInMillis();
        Log.e("xdd", "currentData: " + currentDateLong);

        String[] firstSplitString = dataFromDatabase.split(" ");
        for (String splited : firstSplitString) {
            try {
                date = Long.parseLong(splited);
            } catch (NumberFormatException e) {
                Log.e("xd", "not a number");
            }
        }
        long resultDate = currentDateLong - date;

        if (date > currentDateLong) {
            Log.e("xdDataMocno", "większe");
        } else {
            Log.e("xdDataMocno", "mniejsze");
        }

        if (date != currentDateLong && resultDate < 3483802645980L) {
            Log.e("xdDataMocno", "Co wywołuje? " + resultDate);
            mView.showNotify();
        }
    }
}