package com.udacity.nanodegree.bakingapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;

public class RecipeActivity extends AppCompatActivity {

    private RecipeDTO recipeDTO;

    public RecipeActivity(RecipeDTO recipeDTO) {
        this.recipeDTO = recipeDTO;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

    }
}
