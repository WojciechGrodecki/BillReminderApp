package com.example.myapplication.ui.fragments.allBills;

import com.example.myapplication.db.model.Bill;

import java.util.List;

public interface AllBillsContract {


    interface Presenter {
        void loadBills();
    }

    interface View {
        void showBills(List<Bill> bills);
    }
}