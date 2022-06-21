package com.example.foodappapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodappapi.R;
import com.example.foodappapi.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categoryLists = new ArrayList<>();

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryLists.get(position);
        Glide
                .with(holder.itemView)
                .load(category.getStrCategoryThumb())
                .into(holder.imageCategory);
        holder.nameCategory.setText(category.getStrCategory());
    }

    @Override
    public int getItemCount() {
        return categoryLists.size();
    }

    public void setCategoryLists(List<Category> categoryLists) {
        this.categoryLists = categoryLists;
        notifyDataSetChanged();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageCategory;
        TextView nameCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCategory = itemView.findViewById(R.id.imageCategory);
            nameCategory = itemView.findViewById(R.id.nameCategory);
        }
    }
}
