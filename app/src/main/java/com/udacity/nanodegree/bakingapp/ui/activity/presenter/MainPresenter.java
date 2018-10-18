package com.udacity.nanodegree.bakingapp.ui.activity.presenter;

import android.os.Bundle;

import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.data.service.BakingService;
import com.udacity.nanodegree.bakingapp.ui.activity.MainActivity;
import com.udacity.nanodegree.bakingapp.ui.activity.adapter.MainRecipesAdapter;
import com.udacity.nanodegree.bakingapp.utils.RetrofitUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private static final String RECIPES_STATE = "RECIPES_STATE";
    private final BakingService service;
    private MainActivity activity;
    private MainRecipesAdapter adapter;

    public MainPresenter(MainActivity activity) {
        this.activity = activity;
        this.service = RetrofitUtils.getBakingService();
    }

    public void loadRecipesAdapter() {
        if (adapter == null)
            this.adapter = new MainRecipesAdapter();
        else
            return;

        activity.toggleLoading();

        service.getRecipes().enqueue(new Callback<List<RecipeDTO>>() {
            @Override
            public void onResponse(Call<List<RecipeDTO>> call, Response<List<RecipeDTO>> response) {
                activity.toggleLoading();
                adapter.setItems(response.body());
                activity.setRecipesAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<RecipeDTO>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
