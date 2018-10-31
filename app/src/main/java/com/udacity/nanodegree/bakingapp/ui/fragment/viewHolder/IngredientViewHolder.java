package com.udacity.nanodegree.bakingapp.ui.fragment.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.IngredientsDTO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ingredient_text)
    TextView ingredientText;
    @BindView(R.id.quantity_text)
    TextView quantityText;
    @BindView(R.id.measure_text)
    TextView measureText;

    public IngredientViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(IngredientsDTO item) {
        ingredientText.setText(item.getIngredient());
        quantityText.setText(String.valueOf(item.getQuantity()));
        measureText.setText(item.getMeasure());
    }
}
