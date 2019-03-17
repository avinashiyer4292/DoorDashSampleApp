package com.example.aviyer.doordashsampleapp;

import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RestaurantUnitTest {

    private Restaurant r;
    @Before
    public void setRestaurantObject(){
        r = new Restaurant("Thirsty Bear Brewing Co","BrewPub",null,"20 mins",0.0f);
    }


    @Test
    public void verifyIfNameNotEmpty() {
        assertNotEquals(r.getName(), "");
    }

    @Test
    public void verifyIfNameSetCorrectly(){
        r.setName("Lee's Deli");
        assertEquals(r.getName(), "Lee's Deli");
    }
}