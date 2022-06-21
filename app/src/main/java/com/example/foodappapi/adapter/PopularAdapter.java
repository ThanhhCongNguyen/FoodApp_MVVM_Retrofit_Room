package com.example.foodappapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodappapi.R;
import com.example.foodappapi.model.MealsByCategory;

import java.util.ArrayList;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private List<MealsByCategory> mealsByCategories = new ArrayList<>();
    private AdapterCallback adapterCallback;

    public interface AdapterCallback {
        void goToDetailActivity(MealsByCategory mealsByCategory);
    }

    public PopularAdapter(AdapterCallback adapterCallback) {
        this.adapterCallback = adapterCallback;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular, parent, false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        MealsByCategory mealsByCategory = mealsByCategories.get(position);
        Glide
                .with(holder.itemView)
                .load(mealsByCategory.getStrMealThumb())
                .into(holder.itemImage);
        holder.itemView.setOnClickListener(view -> {
            adapterCallback.goToDetailActivity(mealsByCategory);
        });
    }

    @Override
    public int getItemCount() {
        return mealsByCategories.size();
    }

    public void setMealsByCategories(List<MealsByCategory> mealsByCategories) {
        this.mealsByCategories = mealsByCategories;
        notifyDataSetChanged();
    }

    static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
