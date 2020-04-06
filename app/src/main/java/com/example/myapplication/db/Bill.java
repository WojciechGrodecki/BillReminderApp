package com.example.myapplication.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "bills")
public class Bill {
    @PrimaryKey(autoGenerate = true)
        public int id;

    @ColumnInfo(name = "title")
        public String title;

    @ColumnInfo(name = "content")
        public String content;

    @ColumnInfo(name = "amunt")
        public int amount;

    @ColumnInfo(name = "paid")
        public String paid;

    @ColumnInfo(name = "term")
        public String term;

}