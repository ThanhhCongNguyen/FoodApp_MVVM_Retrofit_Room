package com.example.foodappapi.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface RetrofitInstance {

    String URL = "https://www.themealdb.com/api/json/v1/1/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    MealAPI mealApi = retrofit.create(MealAPI.class);
}
