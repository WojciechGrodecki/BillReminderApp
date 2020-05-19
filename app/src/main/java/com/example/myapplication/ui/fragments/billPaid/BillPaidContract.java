package com.example.myapplication.ui.fragments.billPaid;

import androidx.annotation.NonNull;

import com.example.myapplication.db.model.Bill;

import java.util.List;

public interface BillPaidContract {


    interface Presenter {
        void loadBills();
    }

    interface View {
        void showBills(@NonNull List<Bill> bills);
    }
}