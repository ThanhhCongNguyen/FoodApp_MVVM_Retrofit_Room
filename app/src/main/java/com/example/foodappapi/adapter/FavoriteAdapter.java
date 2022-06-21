package com.example.foodappapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodappapi.R;
import com.example.foodappapi.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoritesViewHolder> {

    private List<Meal> meals = new ArrayList<>();

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorites, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        Meal meal = meals.get(position);
        Glide
                .with(holder.itemView)
                .load(meal.getStrMealThumb())
                .into(holder.favoritesImage);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    class FavoritesViewHolder extends RecyclerView.ViewHolder {

        ImageView favoritesImage;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            favoritesImage = itemView.findViewById(R.id.favoritesImage);
        }
    }
}
