package com.example.foodappapi.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodappapi.model.Category;
import com.example.foodappapi.model.CategoryList;
import com.example.foodappapi.model.Meal;
import com.example.foodappapi.model.MealList;
import com.example.foodappapi.model.MealsByCategory;
import com.example.foodappapi.model.MealsByCategoryList;
import com.example.foodappapi.repository.MealRepository;
import com.example.foodappapi.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealViewModel extends ViewModel {

    private MutableLiveData<Meal> randomMealLiveData = new MutableLiveData<>();
    private MutableLiveData<Meal> mealDetailLiveData = new MutableLiveData<>();
    private MutableLiveData<List<MealsByCategory>> popularItemLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Category>> categoryLiveData = new MutableLiveData<>();

    public LiveData<List<Meal>> getAllMeal;
    private MealRepository mealRepository;

    public void getRandomMeal() {
        RetrofitInstance.mealApi.getRandomMeal().enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                if (response.body() != null) {
                    Meal meal = response.body().getMeals().get(0);
                    randomMealLiveData.setValue(meal);
                } else {
                    return;
                }
            }

            @Override
            public void onFailure(Call<MealList> call, Throwable t) {

            }
        });
    }

    public void getMealDetails(String id) {
        RetrofitInstance.mealApi.getMealDetails(id).enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                if (response.body() != null) {
                    Meal meal = response.body().getMeals().get(0);
                    mealDetailLiveData.setValue(meal);
                }
            }

            @Override
            public void onFailure(Call<MealList> call, Throwable t) {

            }
        });
    }

    public void getPopularItems() {
        RetrofitInstance.mealApi.getPopularItems("Seafood").enqueue(new Callback<MealsByCategoryList>() {
            @Override
            public void onResponse(Call<MealsByCategoryList> call, Response<MealsByCategoryList> response) {
                if (response.body() != null) {
                    popularItemLiveData.setValue(response.body().getmMeals());
                    Log.e("tag", popularItemLiveData.getValue().get(0).getStrMealThumb());
                } else {
                    return;
                }
            }

            @Override
            public void onFailure(Call<MealsByCategoryList> call, Throwable t) {

            }
        });
    }

    public void getCategory() {
        RetrofitInstance.mealApi.getCategories().enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                if (response.body() != null) {
                    categoryLiveData.setValue(response.body().getCategories());
                } else {
                    return;
                }
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {

            }
        });
    }

    public void initRepository(Context context) {
        mealRepository = new MealRepository(context);
        getAllMeal = mealRepository.getAllMeal;
    }

    public void insert(Meal meal) {
        mealRepository.insert(meal);
    }

    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }

    public LiveData<Meal> observeRandomMealLiveData() {
        return randomMealLiveData;
    }

    public LiveData<Meal> observeMealDetailLiveData() {
        return mealDetailLiveData;
    }

    public LiveData<List<MealsByCategory>> observePopularMealLiveData() {
        return popularItemLiveData;
    }

    public LiveData<List<Category>> observeCategory() {
        return categoryLiveData;
    }

}
