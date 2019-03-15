package com.example.aviyer.doordashsampleapp.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.widget.Toast;
import com.example.aviyer.doordashsampleapp.R;
import com.example.aviyer.doordashsampleapp.adapters.RestaurantListAdapter;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import com.example.aviyer.doordashsampleapp.viewmodels.RestaurantsViewModel;

import java.util.List;

public class RestaurantListActivity extends AppCompatActivity {

    private RestaurantsViewModel mViewModel;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        //recycler view init
        mRecyclerView = findViewById(R.id.restaurant_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);

        //set adapter
        final RestaurantListAdapter adapter = new RestaurantListAdapter(this);
        mRecyclerView.setAdapter(adapter);

        //view model init
        mViewModel  = ViewModelProviders.of(this).get(RestaurantsViewModel.class);
        if(isNetworkAvailable(this)){
            Log.d("Network!!","IS avaialbale");
            mViewModel.getAllRestaurantsFromApi();
        }else{
            Toast.makeText(this, "No internet connection found, Loading offline data!!!", Toast.LENGTH_LONG).show();
        }
        mViewModel.getAllRestaurantsFromDB().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(@Nullable List<Restaurant> restaurants) {
                adapter.setRestaurants(restaurants);
            }
        });



    }

    private boolean isNetworkAvailable(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
