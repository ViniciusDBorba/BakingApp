package com.udacity.nanodegree.bakingapp.ui.fragment.presenter;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.ui.activity.RecipeActivity;
import com.udacity.nanodegree.bakingapp.ui.fragment.adapter.IngredientsAdapter;
import com.udacity.nanodegree.bakingapp.ui.fragment.adapter.StepsAdapter;

public class RecipeDescriptionContentPresenter {

    private final RecipeDTO recipe;
    private final RecipeActivity activity;
    private IngredientsAdapter ingredientsAdapter;
    private StepsAdapter stepsAdapter;

    public RecipeDescriptionContentPresenter(RecipeActivity activity, RecipeDTO recipeDTO) {
        this.recipe = recipeDTO;
        this.activity = activity;
    }


    public void loadIngredientsAdapter() {
        if (ingredientsAdapter == null) {
            this.ingredientsAdapter = new IngredientsAdapter(recipe.getIngredients());
            activity.setIngredientsAdapter(ingredientsAdapter);
        }
    }

    public void loadStepsAdapter() {
        if (stepsAdapter == null) {
            this.stepsAdapter = new StepsAdapter(recipe.getSteps());
            activity.setStepsAdapter(stepsAdapter);
        }
    }

    public String getServingText() {
        return activity.getResources().getString(R.string.serving, recipe.getServings());
    }
}
