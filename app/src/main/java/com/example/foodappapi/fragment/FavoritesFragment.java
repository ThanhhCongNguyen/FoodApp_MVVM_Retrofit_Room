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

import com.example.foodappapi.adapter.FavoriteAdapter;
import com.example.foodappapi.databinding.FragmentFavoritesBinding;
import com.example.foodappapi.viewmodel.MealViewModel;

public class FavoritesFragment extends Fragment {

    private static final int SPAN_COUNT = 3;

    private MealViewModel mealViewModel;
    private FavoriteAdapter favoriteAdapter;
    private FragmentFavoritesBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        mealViewModel.initRepository(getContext());
        favoriteAdapter = new FavoriteAdapter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerFavorites.setAdapter(favoriteAdapter);
        binding.recyclerFavorites.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));

        mealViewModel.getAllMeal.observe(getViewLifecycleOwner(), meals -> {
            favoriteAdapter.setMeals(meals);
        });
    }
}