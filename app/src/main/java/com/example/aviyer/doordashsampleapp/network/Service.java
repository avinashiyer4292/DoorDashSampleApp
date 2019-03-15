package com.example.aviyer.doordashsampleapp.network;

import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Service {
    @GET("/v2/restaurant/?lat=37.422740&lng=-122.139956")
    Call<List<Restaurant>> getQuestions();
}
