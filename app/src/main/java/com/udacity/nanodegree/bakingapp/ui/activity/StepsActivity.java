package com.udacity.nanodegree.bakingapp.ui.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;
import com.udacity.nanodegree.bakingapp.ui.activity.adapter.StepsPagerAdapter;
import com.udacity.nanodegree.bakingapp.ui.activity.presenter.StepsPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepsActivity extends AppCompatActivity {


    public static final String RECIPE_EXTRA = "RECIPE_EXTRA";
    private StepsPresenter presenter;

    @BindView(R.id.steps_pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        ButterKnife.bind(this);
        this.presenter = new StepsPresenter(this, (List) Objects.requireNonNull(getIntent().getExtras().getParcelableArrayList(RECIPE_EXTRA)));

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadPagerAdapter();
    }

    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }

    public void setStepsAdapter(StepsPagerAdapter adapter) {
        pager.setAdapter(adapter);
    }
}
