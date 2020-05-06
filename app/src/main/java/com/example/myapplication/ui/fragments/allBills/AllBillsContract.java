package com.example.myapplication.ui.fragments.allBills;

import androidx.annotation.NonNull;

import com.example.myapplication.db.model.Bill;

import java.util.List;

public interface AllBillsContract {


    interface Presenter {
        void loadBills();
    }

    interface View {
        void showBills(@NonNull List<Bill> bills);
    }
}