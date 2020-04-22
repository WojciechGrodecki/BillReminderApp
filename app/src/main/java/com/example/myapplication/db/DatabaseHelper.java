package com.example.myapplication.db;

import androidx.annotation.NonNull;

import com.example.myapplication.db.model.Bill;

import java.util.List;


public interface DatabaseHelper {

     void insertBills (@NonNull List<Bill> tasks);

     @NonNull
     List<Bill> getAllBills();

     void updateBill(@NonNull Bill bill);

     boolean isEmpty();
}
