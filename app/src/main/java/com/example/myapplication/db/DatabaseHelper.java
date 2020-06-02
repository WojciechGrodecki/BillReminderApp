package com.example.myapplication.db;

import androidx.annotation.NonNull;

import com.example.myapplication.db.model.Bill;

import java.util.List;

import io.requery.query.Tuple;


public interface DatabaseHelper {

     void insertBills (@NonNull List<Bill> bill);

     void deleteBill(@NonNull List<Bill> bill);

     @NonNull
     List<Bill> getAllBills();

     @NonNull
     List<Tuple> getAllBillsDate();

     @NonNull
     List<Tuple> getAllBillsDateTime();

     @NonNull
     List<Tuple> getAllBillsStatus();

     @NonNull
     List<Tuple> getAllBillsCycleAndDate();


     void updateBill(@NonNull Bill bill);

     boolean isEmpty();

}
