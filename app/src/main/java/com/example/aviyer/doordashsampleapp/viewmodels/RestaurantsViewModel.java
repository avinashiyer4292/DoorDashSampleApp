package com.example.aviyer.doordashsampleapp.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import com.example.aviyer.doordashsampleapp.database.repository.RestaurantsRepository;

import java.util.List;

public class RestaurantsViewModel extends AndroidViewModel {

    private RestaurantsRepository mRepository;
    private LiveData<List<Restaurant>> mAllRestaurants;

    public RestaurantsViewModel(Application application){
        super(application);
        mRepository =  new RestaurantsRepository(application);
        mAllRestaurants = mRepository.getmAllRestaurants();
    }

    LiveData<List<Restaurant>> getAllRestaurants(){
        return mAllRestaurants;
    }
}
