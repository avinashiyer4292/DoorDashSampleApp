package com.example.aviyer.doordashsampleapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.aviyer.doordashsampleapp.R;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView adapter class to setup adapter containing list of restaurants
 * */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantHolder> {

    private Context mContext;
    private List<Restaurant> mRestaurants = new ArrayList<>();

    public RestaurantListAdapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurant_list_item, viewGroup, false);
        return new RestaurantHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantHolder restaurantHolder, int i) {
        Restaurant current = mRestaurants.get(i);
        String imageUrl = current.getCoverImgUrl();
        Picasso.get().load(imageUrl).into(restaurantHolder.mImageView);
        restaurantHolder.mName.setText(current.getName());
        restaurantHolder.mDescription.setText(current.getDescription());
        restaurantHolder.mStatus.setText(current.getStatus());

    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public Restaurant getItemAtPosition(int i){
        return this.mRestaurants.get(i);
    }

    public void setRestaurants(List<Restaurant> mRestaurants){
        this.mRestaurants = mRestaurants;
    }


    public class RestaurantHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mName, mDescription, mStatus;

        public RestaurantHolder(View item){
            super(item);
            mImageView = item.findViewById(R.id.restaurant_image);
            mName = item.findViewById(R.id.restaurant_name);
            mDescription = item.findViewById(R.id.restaurant_description);
            mStatus = item.findViewById(R.id.restaurant_status);
        }
    }
}
