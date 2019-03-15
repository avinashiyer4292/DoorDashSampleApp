package com.example.aviyer.doordashsampleapp.database.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import com.example.aviyer.doordashsampleapp.database.RestaurantsDB;
import com.example.aviyer.doordashsampleapp.database.dao.RestaurantsDao;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;

import java.util.List;

public class RestaurantsRepository {

    private RestaurantsDao mRestaurantsDao;
    private LiveData<List<Restaurant>> mAllRestaurants;

    public RestaurantsRepository(Application application){
        RestaurantsDB db = RestaurantsDB.getInstance(application);
        mRestaurantsDao = db.dao();
        mAllRestaurants = mRestaurantsDao.getAllRestaurants();
        }

    public LiveData<List<Restaurant>> getmAllRestaurants(){
        return mAllRestaurants;
    }


}

