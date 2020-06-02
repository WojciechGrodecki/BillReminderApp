package com.example.myapplication.ui.activity.mainActivity;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.myapplication.BillReminderApplication;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.db.model.Bill;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private String callendarDate;
    private String callendarDateTime;
    private String mCycle;
    private long date;
    private long cycleLong;
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
        Log.e("xdDataMocno", "Roznica " + resultDate);

        // Wywołaj notyfikacje jesli aktualna data - data jakiegos rachunku to mniej niz 3 dni
        // Obliczone za pomoca daty 5 czerwca odjac aktualna (roznica bedzie zawsze stala)
        if (resultDate != currentDateLong && resultDate < 1591125908808L - 1591125889685L) {
            Log.e("xdDataMocno", "Co wywołuje? " + resultDate);
            mView.showNotify();
        }
        mCycle = databaseHelper.getAllBillsCycleAndDate().toString();
        Log.e("xd", "cycle?" + mCycle);
        separateCycle(mCycle);
    }

    private void separateCycle(String cycle) {
        String[] firstSplitString = cycle.split("\\[");
        for (String splited : firstSplitString) {
            String[] secondSplitString = splited.split("\\]");
            for (String secondSplited : secondSplitString) {
                String[] thirdSplitString = secondSplited.split(",");
                for (String thirdSplited : thirdSplitString) {
                    String[] quater = thirdSplited.split(" ");
                    for (String cycleBill : quater) {
                        try {
                            cycleLong = Long.parseLong(cycleBill);
                        } catch (NumberFormatException e) {
                            Log.e("xd", "not a number");
                        }
                    }
                }
            }
        }
        long currentDateLong = GregorianCalendar.getInstance().getTimeInMillis();
        if (cycleLong > 1000 && date == currentDateLong) {
            long exdate = currentDateLong + cycleLong;
            String dateEx = String.valueOf(exdate);
            String BillName = "bill name";
            String BillStatus = "bill status";
            int BillPrize = 123;
            databaseHelper.insertBills(createBills(BillName, BillStatus, BillPrize, dateEx, String.valueOf(cycleLong), exdate));
        }
    }

    private List<Bill> createBills(String BillName, String BillStatus, int BillPrize, String BillDate, String Billcycle, Long dateTime) {
        List<Bill> bills = new ArrayList<>();
        Bill bill = new Bill();
        bill.setBillName(BillName);
        bill.setBillPrice(BillPrize);
        bill.setStatus(BillStatus);
        bill.setBillDate(BillDate);
        bill.setRepeat(Billcycle);
        bill.setDateTime(dateTime);
        bills.add(bill);
        return bills;
    }

}