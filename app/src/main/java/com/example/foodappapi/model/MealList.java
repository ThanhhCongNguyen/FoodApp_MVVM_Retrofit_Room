package com.example.foodappapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class MealList {

    @SerializedName("meals")
    private List<Meal> mMeals;

    public List<Meal> getMeals() {
        return mMeals;
    }

    public void setMeals(List<Meal> meals) {
        mMeals = meals;
    }

}
