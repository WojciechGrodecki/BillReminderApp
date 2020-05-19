package com.example.myapplication.ui.fragments.addBill;

import androidx.annotation.NonNull;

public interface AddBillContract {

    interface Presenter {
      void  addNewBill(@NonNull String BillName, @NonNull String BillStatus, int BillPrize,String BillDate,String BillCycle);
    }

    interface View {
    }
}