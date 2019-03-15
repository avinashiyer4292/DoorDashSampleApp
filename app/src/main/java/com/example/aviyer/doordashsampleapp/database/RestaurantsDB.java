package com.example.aviyer.doordashsampleapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.aviyer.doordashsampleapp.database.dao.RestaurantsDao;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;

@Database(entities = {Restaurant.class}, version = 1)
public abstract class RestaurantsDB extends RoomDatabase {

    public abstract RestaurantsDao dao();
    private static RestaurantsDB instance;

    public static RestaurantsDB getInstance(final Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            RestaurantsDB.class, "restaurants_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

//    private static RoomDatabase.Callback dbCallback = onCreate(db) ->{
//        super.onCreate
//    }};


}
