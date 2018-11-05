package com.udacity.nanodegree.bakingapp.ui.activity.presenter;

import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;
import com.udacity.nanodegree.bakingapp.ui.activity.StepsActivity;
import com.udacity.nanodegree.bakingapp.ui.activity.adapter.StepsPagerAdapter;

import java.util.List;

public class StepsPresenter {

    private final List<StepsDTO> steps;
    private final StepsActivity activity;
    private StepsPagerAdapter adapter;

    public StepsPresenter(StepsActivity activity, RecipeDTO recipe) {
        this.steps = recipe.getSteps();
        this.activity = activity;
    }

    public void loadPagerAdapter() {
        if (adapter != null)
            return;

        this.adapter = new StepsPagerAdapter(activity.getSupportFragmentManager());
        activity.setStepsAdapter(adapter);

    }
}
