package com.example.foodappapi.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@SuppressWarnings("unused")
@Entity(tableName = "MealDatabase")
public class Meal implements Serializable {

    @SerializedName("idMeal")
    @PrimaryKey()
    @NotNull
    private String mIdMeal;

    @SerializedName("strArea")
    private String mStrArea;

    @SerializedName("strCategory")
    private String mStrCategory;

    @SerializedName("strInstructions")
    private String mStrInstructions;

    @SerializedName("strMeal")
    private String mStrMeal;

    @SerializedName("strMealThumb")
    private String mStrMealThumb;

    @SerializedName("strYoutube")
    private String mStrYoutube;

    public String getIdMeal() {
        return mIdMeal;
    }

    public void setIdMeal(String idMeal) {
        mIdMeal = idMeal;
    }

    public String getStrArea() {
        return mStrArea;
    }

    public void setStrArea(String strArea) {
        mStrArea = strArea;
    }

    public String getStrCategory() {
        return mStrCategory;
    }

    public void setStrCategory(String strCategory) {
        mStrCategory = strCategory;
    }

    public String getStrInstructions() {
        return mStrInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        mStrInstructions = strInstructions;
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

    public String getStrYoutube() {
        return mStrYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        mStrYoutube = strYoutube;
    }

}
