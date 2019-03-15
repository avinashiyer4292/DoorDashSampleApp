package com.example.aviyer.doordashsampleapp.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;

import java.util.List;

@Dao
public interface RestaurantsDao {

    @Query("Select * from restaurants")
    LiveData<List<Restaurant>> getAllRestaurants();

}
