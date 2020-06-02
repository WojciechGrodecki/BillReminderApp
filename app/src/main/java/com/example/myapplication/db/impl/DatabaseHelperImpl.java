package com.example.myapplication.db.impl;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.db.model.Bill;
import com.example.myapplication.db.model.Models;

import java.util.List;

import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.query.Tuple;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;

public class DatabaseHelperImpl implements DatabaseHelper {
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelperImpl sInstance;
    private EntityDataStore<Persistable> mDataStore;

    private DatabaseHelperImpl(@NonNull Context context) {
        mDataStore = getDataStore(context);
    }

    public static DatabaseHelperImpl getInstance(@NonNull Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelperImpl(context);
        }

        return sInstance;
    }

    private static @NonNull
    EntityDataStore<Persistable> getDataStore(@NonNull Context context) {
        DatabaseSource source = new DatabaseSource(context, Models.DEFAULT, DATABASE_VERSION);
        source.setLoggingEnabled(true);
        Configuration configuration = source.getConfiguration();
        return new EntityDataStore<>(configuration);
    }

    @Override
    public void insertBills(@NonNull List<Bill> bill) {
        mDataStore.insert(bill);
    }

    @Override
    public void deleteBill(@NonNull List<Bill> bill) {
        mDataStore.delete(bill);
    }

    @NonNull
    @Override
    public List<Bill> getAllBills() {
        return mDataStore.select(Bill.class).get().toList();
    }

    @NonNull
    @Override
    public List<Tuple> getAllBillsDate() {
        return mDataStore.select(Bill.BILL_DATE).get().toList();
    }

    @NonNull
    @Override
    public List<Tuple> getAllBillsDateTime() {
        return mDataStore.select(Bill.DATE_TIME).get().toList();
    }

    @NonNull
    @Override
    public List<Tuple> getAllBillsStatus() {
        return mDataStore.select(Bill.STATUS).get().toList();
    }

    @NonNull
    @Override
    public List<Tuple> getAllBillsCycleAndDate() {
        return mDataStore.select(Bill.REPEAT).get().toList();
    }

    @Override
    public void updateBill(@NonNull Bill bill) {
        mDataStore.update(bill);
    }

    @Override
    public boolean isEmpty() {
        return mDataStore.count(Bill.class).get().value().equals(0);
    }

}
