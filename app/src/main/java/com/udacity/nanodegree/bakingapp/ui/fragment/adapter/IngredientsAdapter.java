package com.udacity.nanodegree.bakingapp.ui.fragment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.IngredientsDTO;
import com.udacity.nanodegree.bakingapp.ui.fragment.viewHolder.IngredientViewHolder;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private final List<IngredientsDTO> ingredients;

    public IngredientsAdapter(List<IngredientsDTO> ingredientsDTOS) {
        this.ingredients = ingredientsDTOS;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingredient_recycler_item, viewGroup, false);
        return new IngredientViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder ingredientViewHolder, int i) {
        ingredientViewHolder.bind(getItem(i));
    }

    private IngredientsDTO getItem(int position) {
        return ingredients.get(position);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}
