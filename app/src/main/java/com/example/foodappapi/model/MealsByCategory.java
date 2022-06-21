
package com.example.foodappapi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("unused")
public class MealsByCategory implements Serializable {

    @SerializedName("idMeal")
    private String mIdMeal;

    @SerializedName("strMeal")
    private String mStrMeal;

    @SerializedName("strMealThumb")
    private String mStrMealThumb;

    public MealsByCategory(String mIdMeal, String mStrMeal, String mStrMealThumb) {
        this.mIdMeal = mIdMeal;
        this.mStrMeal = mStrMeal;
        this.mStrMealThumb = mStrMealThumb;
    }

    public String getIdMeal() {
        return mIdMeal;
    }

    public void setIdMeal(String idMeal) {
        mIdMeal = idMeal;
    }

    public String getStrMeal() {
        return mStrMeal;
    }

    public void setStrMeal(String strMeal) {
        mStrMeal = strMeal;
    }

    public String getStrMealThumb() {
        return mStrMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        mStrMealThumb = strMealThumb;
    }

}
