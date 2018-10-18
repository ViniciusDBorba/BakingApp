package com.udacity.nanodegree.bakingapp.ui.activity.adapter;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.ui.activity.viewHolder.RecipeItemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainRecipesAdapter extends RecyclerView.Adapter<RecipeItemViewHolder> {

    private List<RecipeDTO> recipes = new ArrayList<>();

    public MainRecipesAdapter(List<RecipeDTO> recipes) {
        this.recipes.addAll(recipes);
    }

    public MainRecipesAdapter() {
    }

    @NonNull
    @Override
    public RecipeItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipes_recycler_item, viewGroup, false);
        return new RecipeItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeItemViewHolder recipeItemViewHolder, int i) {
        recipeItemViewHolder.bind(getItem(i));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public RecipeDTO getItem(int position) {
        return recipes.get(position);
    }

    public void setItems(List<RecipeDTO> body) {
        recipes = body;
        notifyDataSetChanged();
    }

    public List<RecipeDTO> getItems() {
        return recipes;
    }
}
