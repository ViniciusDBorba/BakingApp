package com.udacity.nanodegree.bakingapp.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.ui.activity.adapter.StepsPagerAdapter;
import com.udacity.nanodegree.bakingapp.ui.activity.presenter.StepsPresenter;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepsActivity extends AppCompatActivity {


    public static final String RECIPE_EXTRA = "RECIPE_EXTRA";
    public static final String STEP_POSITION_EXTRA = "POSITION";
    private StepsPresenter presenter;

    @BindView(R.id.steps_pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        ButterKnife.bind(this);
        this.presenter = new StepsPresenter(this, (List) Objects.requireNonNull(getIntent().getExtras().getParcelableArrayList(RECIPE_EXTRA)), getIntent().getExtras().getInt(STEP_POSITION_EXTRA));

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadPagerAdapter();
    }


    public void setStepsAdapter(StepsPagerAdapter adapter, int position) {
        pager.setAdapter(adapter);
        pager.setCurrentItem(position);
    }
}
