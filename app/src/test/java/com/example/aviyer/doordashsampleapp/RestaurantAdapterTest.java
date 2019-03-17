package com.example.aviyer.doordashsampleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.example.aviyer.doordashsampleapp.adapters.RestaurantListAdapter;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RecyclerView.Adapter.class)
public class RestaurantAdapterTest {
    private RestaurantListAdapter mAdapter;
    private Context mockContext = mock(Context.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mAdapter = new RestaurantListAdapter(mockContext);
        Restaurant r1 = new Restaurant("Fang","Chinese", null, "CLosed", 2.0f);
        Restaurant r2 = new Restaurant("The Melt","CheeseBurgers", null, "30 mins", 2.0f);
        Restaurant r3 = new Restaurant("HEYDAY","Soups", null, "15 mins", 21.0f);
        List<Restaurant> list = new ArrayList<>(Arrays.asList(r1,r2,r3));
        mAdapter.setRestaurants(list);
    }
    @Test
    public void itemCount() {
        assertEquals(mAdapter.getItemCount(),3);
    }

    @Test
    public void verifyItemNameAtPosition() {
        assertEquals(mAdapter.getItemAtPosition(2).getName(),"HEYDAY");
    }
    @Test
    public void verifyItemDescriptionAtPosition() {
        assertEquals(mAdapter.getItemAtPosition(1).getDescription(),"CheeseBurgers");
    }
    @Test
    public void verifyItemDeliveryFeeAtPosition() {
        assertEquals(mAdapter.getItemAtPosition(2).getDeliveryFee(),21.0f, 0.0f);
    }
    @Test
    public void verifyItemChangedCorrectly(){
        mAdapter.getItemAtPosition(0).setStatus("Open");
        assertNotEquals(mAdapter.getItemAtPosition(0).getStatus(),"30 mins");
    }


}
