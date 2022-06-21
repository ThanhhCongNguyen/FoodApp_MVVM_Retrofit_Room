
package com.example.foodappapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class MealsByCategoryList {

    @SerializedName("meals")
    private List<MealsByCategory> mMeals;

    public List<MealsByCategory> getmMeals() {
        return mMeals;
    }

    public void setmMeals(List<MealsByCategory> mMeals) {
        this.mMeals = mMeals;
    }
}
