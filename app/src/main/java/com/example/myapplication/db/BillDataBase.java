package com.example.myapplication.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Bill.class}, version = 1, exportSchema = false)
public abstract class BillDataBase  extends RoomDatabase {
    public abstract DataBaseDAO billDao();

    private static volatile BillDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static BillDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BillDataBase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BillDataBase.class, "bill_database")
                            .build();
                }
            }

        }
        return INSTANCE;
    }
}


