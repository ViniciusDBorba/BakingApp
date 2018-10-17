package com.udacity.nanodegree.bakingapp.ui.activity.presenter;

import com.udacity.nanodegree.bakingapp.data.service.BakingService;
import com.udacity.nanodegree.bakingapp.ui.activity.MainActivity;
import com.udacity.nanodegree.bakingapp.utils.RetrofitUtils;

public class MainPresenter {

    private final BakingService service;
    private MainActivity activity;

    public MainPresenter(MainActivity activity) {
        this.activity = activity;
        this.service = RetrofitUtils.getBakingService();
    }
}
