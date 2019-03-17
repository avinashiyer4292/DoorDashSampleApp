package com.example.aviyer.doordashsampleapp.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Service generator class which creates retrofit abd okhttp client objects to perform API request response
 * */
public class ServiceGenerator {
    //createService (APIServce.class)
    public static <S> S createService(Class<S> serviceClass){
        Retrofit.Builder builder = retrofitBuilder(UrlConfig.DOORDASH_RESTAURANTS_BASE_URL);
        OkHttpClient.Builder httpClient = httpClientBuilder();
        builder.client(httpClient.build());
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    private static Retrofit.Builder retrofitBuilder(String baseURL){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseURL);
    }

    private static OkHttpClient.Builder httpClientBuilder(){
        return new OkHttpClient.Builder()
                .readTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS)
                .connectTimeout(90, TimeUnit.SECONDS)
                .cache(null);
    }
}
