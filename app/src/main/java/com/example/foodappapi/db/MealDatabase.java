package com.example.foodappapi.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodappapi.model.Meal;

@Database(entities = Meal.class, version = 1, exportSchema = false)
public abstract class MealDatabase extends RoomDatabase {

    public abstract MealDao mealDao();
    private static MealDatabase INSTANCE;

    public static MealDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MealDatabase.class, "MealDatabase").build();
        }
        return INSTANCE;
    }
}
