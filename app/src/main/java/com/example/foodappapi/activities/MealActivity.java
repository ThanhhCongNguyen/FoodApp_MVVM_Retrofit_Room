package com.example.foodappapi.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.foodappapi.databinding.ActivityMealBinding;
import com.example.foodappapi.model.Meal;
import com.example.foodappapi.model.MealsByCategory;
import com.example.foodappapi.viewmodel.MealViewModel;

public class MealActivity extends AppCompatActivity {

    private static final String MEAL = "meal";
    private static final String MEAL_BY_CATEGORY = "mealByCategory";

    private ActivityMealBinding binding;
    private MealViewModel mealViewModel;
    private String idMeal = "";
    private Meal meal;

    public static void starterMeal(Context context, Meal meal) {
        Intent intent = new Intent(context, MealActivity.class);
        intent.putExtra(MEAL, meal);
        context.startActivity(intent);
    }

    public static void starterMealByCategory(Context context, MealsByCategory mealsByCategory) {
        Intent intent = new Intent(context, MealActivity.class);
        intent.putExtra(MEAL_BY_CATEGORY, mealsByCategory);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        mealViewModel.initRepository(getApplicationContext());

        Intent intent = getIntent();
        if (intent != null) {
            Meal meal = (Meal) intent.getSerializableExtra(MEAL);
            if (meal != null) {
                idMeal = meal.getIdMeal();
            }

            MealsByCategory mealsByCategory = (MealsByCategory) intent.getSerializableExtra(MEAL_BY_CATEGORY);
            if (mealsByCategory != null) {
                idMeal = mealsByCategory.getIdMeal();
            }

            mealViewModel.getMealDetails(idMeal);
            mealViewModel.observeMealDetailLiveData().observe(this, mealDetail -> {
                this.meal = mealDetail;
                setDataForUI(mealDetail);
            });

        }

        binding.favoriteIcon.setOnClickListener(view -> {
            mealViewModel.insert(meal);
            Toast.makeText(this, "Inserted successfully", Toast.LENGTH_LONG).show();
        });
    }

    private void setDataForUI(Meal meal) {
        binding.collapsingToolbar.setTitle(meal.getStrMeal());
        binding.mealDetailText.setText(meal.getStrInstructions());
        Glide
                .with(this)
                .load(meal.getStrMealThumb())
                .into(binding.imageViewDetail);
        binding.locationText.setText(meal.getStrArea());
        binding.categoryText.setText(meal.getStrCategory());
    }
}