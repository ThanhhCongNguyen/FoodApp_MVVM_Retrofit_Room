package com.example.foodappapi.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.foodappapi.db.MealDatabase;
import com.example.foodappapi.model.Meal;

import java.util.List;

public class MealRepository {

    private MealDatabase mealDatabase;
    public LiveData<List<Meal>> getAllMeal;

    public MealRepository(Context context) {
        mealDatabase = MealDatabase.getInstance(context);
        getAllMeal = mealDatabase.mealDao().getAllMeals();
    }

    public void insert(Meal meal) {
        new Thread(() -> mealDatabase.mealDao().insert(meal)).start();
    }

    public void delete(Meal meal) {
        new Thread(() -> mealDatabase.mealDao().delete(meal)).start();
    }
}
