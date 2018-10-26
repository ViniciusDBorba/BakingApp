package com.udacity.nanodegree.bakingapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;

public class RecipeDescriptionContent extends Fragment {

    private RecipeDTO recipe;

    public RecipeDescriptionContent() {
    }

    public static RecipeDescriptionContent newInstance(RecipeDTO recipeDTO) {
        RecipeDescriptionContent fragment = new RecipeDescriptionContent();
        fragment.recipe = recipeDTO;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe_description_content, container, false);
    }
}
