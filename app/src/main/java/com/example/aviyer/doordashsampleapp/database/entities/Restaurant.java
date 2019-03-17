package com.example.aviyer.doordashsampleapp.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;


/**
 * Model class to define entity to be stored in database
 * */
@Entity(tableName = "restaurants")
public class Restaurant {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "cover_img_url")
    @SerializedName("cover_img_url")
    private String coverImgUrl; //restaurant thumbnail url

    @ColumnInfo(name = "status")
    private String status; //string representing status of the restaurant (“30 mins”, “closed”, etc.)

    @ColumnInfo(name = "delivery_fee")
    private float deliveryFee;


    public Restaurant(String name, String description, String coverImgUrl, String status, float deliveryFee) {

        this.name = name;
        this.description = description;
        this.coverImgUrl = coverImgUrl;
        this.status = status;
        this.deliveryFee = deliveryFee;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
