package com.example.foodappapi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.foodappapi.activities.MealActivity;
import com.example.foodappapi.adapter.CategoryAdapter;
import com.example.foodappapi.adapter.PopularAdapter;
import com.example.foodappapi.databinding.FragmentHomeBinding;
import com.example.foodappapi.model.Meal;
import com.example.foodappapi.model.MealsByCategory;
import com.example.foodappapi.viewmodel.MealViewModel;

public class HomeFragment extends Fragment implements PopularAdapter.AdapterCallback {

    private static final int SPAN_COUNT = 3;

    private FragmentHomeBinding binding;
    private MealViewModel mealViewModel;
    private PopularAdapter popularAdapter;
    private CategoryAdapter categoryAdapter;
    private Meal meal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        popularAdapter = new PopularAdapter(this);
        categoryAdapter = new CategoryAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        displayPopularRecyclerview();
        displayCategoryRecyclerview();

        mealViewModel.getRandomMeal();
        observeRandomMeal();
        onClickRandomMeal();

        mealViewModel.getPopularItems();
        observePopularMeal();

        mealViewModel.getCategory();
        observeCategory();
    }

    private void displayPopularRecyclerview() {
        binding.recyclerPopularItems.setAdapter(popularAdapter);
        binding.recyclerPopularItems.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void displayCategoryRecyclerview() {
        binding.recyclerCategory.setAdapter(categoryAdapter);
        binding.recyclerCategory.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
    }

    private void observeRandomMeal() {
        mealViewModel.observeRandomMealLiveData().observe(getViewLifecycleOwner(), meal -> {
            Glide
                    .with(this)
                    .load(meal.getStrMealThumb())
                    .into(binding.randomImage);
            this.meal = meal;
        });
    }

    private void onClickRandomMeal() {
        binding.randomImage.setOnClickListener(view -> {
            MealActivity.starterMeal(getContext(), this.meal);
        });
    }

    private void observePopularMeal() {
        mealViewModel.observePopularMealLiveData().observe(getViewLifecycleOwner(), mealsByCategories -> {
            popularAdapter.setMealsByCategories(mealsByCategories);
        });
    }

    private void observeCategory() {
        mealViewModel.observeCategory().observe(getViewLifecycleOwner(), categories -> {
            categoryAdapter.setCategoryLists(categories);
        });
    }

    @Override
    public void goToDetailActivity(MealsByCategory mealsByCategory) {
        MealActivity.starterMealByCategory(getContext(), mealsByCategory);
    }
}