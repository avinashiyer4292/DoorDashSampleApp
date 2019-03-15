package com.example.aviyer.doordashsampleapp.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import com.example.aviyer.doordashsampleapp.database.repository.RestaurantsRepository;

import java.util.List;

public class RestaurantsViewModel extends AndroidViewModel {

    public RestaurantsViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new RestaurantsRepository(application);

    }

    private RestaurantsRepository mRepository;

    //we will call this method to get the data
    public LiveData<List<Restaurant>> getAllRestaurantsFromDB() {
        return mRepository.getAllRestaurantsFromDB();
    }

    public void getAllRestaurantsFromApi(){
        mRepository.getAllRestaurantsFromApi(37.422740,-122.139956,0,50);
    }


}
