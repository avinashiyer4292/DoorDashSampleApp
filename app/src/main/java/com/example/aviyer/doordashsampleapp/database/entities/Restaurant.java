package com.example.aviyer.doordashsampleapp.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "restaurants")
public class Restaurant {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "cuisine")
    private String cuisine;

    public Restaurant(int restaurantId, String name, String cuisine) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.cuisine = cuisine;
    }

}
