package com.example.aviyer.doordashsampleapp.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.example.aviyer.doordashsampleapp.database.dao.RestaurantsDao;
import com.example.aviyer.doordashsampleapp.database.entities.Restaurant;


/**
 * Actual database class to persist api response in cache
 * */
@Database(entities = {Restaurant.class}, version = 4)
public abstract class RestaurantsDB extends RoomDatabase {

    public abstract RestaurantsDao dao();
    private static RestaurantsDB instance;

    public static synchronized RestaurantsDB getInstance(final Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            RestaurantsDB.class, "restaurants_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InsertIntoDBAsyncTask(instance).execute();
        }
    };

    //First time db is instantiated, it is populated with random data. In case DB is destroyed, it'll still contain some fields
    private static class InsertIntoDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private RestaurantsDao mDao;

        private InsertIntoDBAsyncTask(RestaurantsDB db){
            this.mDao = db.dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mDao.insert(new Restaurant("Restuarnat 1", "Indian",null, "Closed", 25));
            return null;
        }
    }




}
