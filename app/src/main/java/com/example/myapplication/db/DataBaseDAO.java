package com.example.myapplication.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface DataBaseDAO {

    @Query("SELECT * FROM bills where paid = 'false'")
        List<Bill> getBillsUnpaid();

    @Query("SELECT * FROM bills where paid = 'true'")
        List<Bill> getBillsPaid();

    @Query("SELECT * FROM bills")
         List <Bill> getBills();

    @Query("SELECT * FROM bills WHERE title LIKE title")
         List<Bill> findByTitle(String title);

    @Query("SELECT * FROM bills WHERE id = id")
         List<Bill> getDetail(int id);

    @Insert
     void insert(Bill bill);

    @Delete
     void delete(Bill bill);

    @Update
     void update(Bill bill);
}

