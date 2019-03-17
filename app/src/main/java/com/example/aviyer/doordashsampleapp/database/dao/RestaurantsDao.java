package com.example.aviyer.doordashsampleapp.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;

import java.util.List;

/**
 * DAO class to access and perform database operations
 * */

@Dao
public interface RestaurantsDao {

    @Query("Select * from restaurants")
    LiveData<List<Restaurant>> getAllRestaurants();

    @Insert
    void insert(Restaurant restaurant);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllResturants(List<Restaurant> restaurants);

    @Query("DELETE FROM restaurants")
    void deleteAllRestaurants();

}
