package com.example.myapplication.db.model;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;

@Entity
public abstract class AbstractBill {
    @Key
    @Generated
    int id;
    String status;
    String billName;
}
