package com.udacity.nanodegree.bakingapp.ui.activity.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;
import com.udacity.nanodegree.bakingapp.ui.fragment.StepContentFragment;

import java.util.ArrayList;
import java.util.List;

public class StepsPagerAdapter extends FragmentStatePagerAdapter {
    List<StepsDTO> steps = new ArrayList<>();
    public StepsPagerAdapter(FragmentManager fm, List<StepsDTO> steps) {
        super(fm);
        this.steps = steps;
    }

    @Override
    public StepContentFragment getItem(int i) {
        return StepContentFragment.newInstance(steps.get(i));
    }

    @Override
    public int getCount() {
        return steps.size();
    }
}
