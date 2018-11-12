package com.udacity.nanodegree.bakingapp.ui.activity.presenter;

import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;
import com.udacity.nanodegree.bakingapp.ui.activity.StepsActivity;
import com.udacity.nanodegree.bakingapp.ui.activity.adapter.StepsPagerAdapter;

import java.util.List;

public class StepsPresenter {

    private List<StepsDTO> steps;
    private final StepsActivity activity;
    private final int position;
    private StepsPagerAdapter adapter;

    public StepsPresenter(StepsActivity activity, List<StepsDTO> steps, int position) {
        this.steps = steps;
        this.activity = activity;
        this.position = position;
    }

    public void loadPagerAdapter() {
        if (adapter != null)
            return;

        this.adapter = new StepsPagerAdapter(activity.getSupportFragmentManager(), steps);
        activity.setStepsAdapter(adapter, position);

    }
}
