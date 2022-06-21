package com.example.foodappapi.retrofit;

import com.example.foodappapi.model.CategoryList;
import com.example.foodappapi.model.MealList;
import com.example.foodappapi.model.MealsByCategoryList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealAPI {

    @GET("random.php")
    Call<MealList> getRandomMeal();

    @GET("lookup.php?")
    Call<MealList> getMealDetails(@Query("i") String id);

    @GET("filter.php")
    Call<MealsByCategoryList> getPopularItems(@Query("c") String categoryName);

    @GET("categories.php")
    Call<CategoryList> getCategories();
}
