package com.udacity.nanodegree.bakingapp.data.service;


import com.udacity.nanodegree.bakingapp.data.dto.RecipesDTO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BakingService {

    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<RecipesDTO> getRecipes();
}
