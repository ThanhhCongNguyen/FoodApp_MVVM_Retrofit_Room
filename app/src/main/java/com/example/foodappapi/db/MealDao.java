package com.example.foodappapi.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodappapi.model.Meal;

import java.util.List;

@Dao
public interface MealDao {

    @Query("SELECT * FROM MealDatabase")
    LiveData<List<Meal>> getAllMeals();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Meal meal);

    @Delete
    void delete(Meal meal);
}
