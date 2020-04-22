package com.example.myapplication.ui.fragments.billUnPaid;

import com.example.myapplication.db.model.Bill;

import java.util.List;

public interface BillUnPaidContract {


    interface Presenter {
        void loadBills();
    }

    interface View {
        void showBills(List<Bill> bills);

    }
}