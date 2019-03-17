package com.example.aviyer.doordashsampleapp.network;

import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Interface for performing calls and return response object
 * */

public interface Service {
    @GET("/v2/restaurant/")
    Call<List<Restaurant>> getRestaurants(@Query("lat") double lat,
                                          @Query("lng") double lng,
                                          @Query("offset") int offset,
                                          @Query("limit") int limit);
}
