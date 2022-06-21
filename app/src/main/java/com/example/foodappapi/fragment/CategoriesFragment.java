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

import com.example.foodappapi.adapter.CategoryAdapter;
import com.example.foodappapi.databinding.FragmentCategoriesBinding;
import com.example.foodappapi.viewmodel.MealViewModel;

public class CategoriesFragment extends Fragment {

    private static final int SPAN_COUNT = 3;

    private FragmentCategoriesBinding binding;
    private MealViewModel mealViewModel;
    private CategoryAdapter categoryAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        categoryAdapter = new CategoryAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerCategory.setAdapter(categoryAdapter);
        binding.recyclerCategory.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));

        mealViewModel.getCategory();
        observeCategory();
    }

    private void observeCategory() {
        mealViewModel.observeCategory().observe(getViewLifecycleOwner(), categories -> {
            categoryAdapter.setCategoryLists(categories);
        });
    }
}