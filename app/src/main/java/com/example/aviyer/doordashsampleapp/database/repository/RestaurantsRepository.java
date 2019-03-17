package com.example.aviyer.doordashsampleapp.database.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.widget.Toast;
import com.example.aviyer.doordashsampleapp.database.RestaurantsDB;
import com.example.aviyer.doordashsampleapp.database.dao.RestaurantsDao;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import com.example.aviyer.doordashsampleapp.network.Service;
import com.example.aviyer.doordashsampleapp.network.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;


/**
 * Repository class that performs all business logic , abstracting work away from UI
 * */
public class RestaurantsRepository {

    private RestaurantsDao mRestaurantsDao;
    private Application application;

    public RestaurantsRepository(Application application){
        RestaurantsDB db = RestaurantsDB.getInstance(application);
        mRestaurantsDao = db.dao();
        this.application = application;
        }

    public LiveData<List<Restaurant>> getAllRestaurantsFromDB(){
        return mRestaurantsDao.getAllRestaurants();
    }

    public void getAllRestaurantsFromApi(double lat, double lng, int offset, int limit){

        Service service = ServiceGenerator.createService(Service.class);
        Call<List<Restaurant>> call = service.getRestaurants(lat, lng, offset, limit);
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        Log.d("Get all restaurants!!!!", response.body().get(0).getCoverImgUrl());
                        final List<Restaurant> list = response.body();
                        new Thread ( new Runnable() {
                            @Override
                            public void run() {
                                // This code will run in another thread. Usually as soon as start() gets called!
                                mRestaurantsDao.deleteAllRestaurants();
                                mRestaurantsDao.insertAllResturants(list);
                            }
                        }).start();

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(application, "Could not retrieve restaurants!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

