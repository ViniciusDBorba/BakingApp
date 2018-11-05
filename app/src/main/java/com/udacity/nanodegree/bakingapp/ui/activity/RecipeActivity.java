package com.udacity.nanodegree.bakingapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.ui.components.SaveInstanceRecyclerView;
import com.udacity.nanodegree.bakingapp.ui.activity.adapter.IngredientsAdapter;
import com.udacity.nanodegree.bakingapp.ui.activity.adapter.StepsAdapter;
import com.udacity.nanodegree.bakingapp.ui.activity.presenter.RecipePresenter;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {

    public static final String RECIPE_EXTRA = "recipe";
    private RecipePresenter presenter;

    @BindView(R.id.ingredients_recycler)
    SaveInstanceRecyclerView ingredientsRecyclerView;
    @BindView(R.id.steps_recycler)
    SaveInstanceRecyclerView stepsRecyclerView;
    @BindView(R.id.serving)
    TextView serving;

    public RecipeActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);
        this.presenter = new RecipePresenter(this, (RecipeDTO) Objects.requireNonNull(getIntent().getExtras()).getParcelable(RECIPE_EXTRA));

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshView();
    }

    private void refreshView() {
        serving.setText(presenter.getServingText());

        ingredientsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        presenter.loadIngredientsAdapter();

        stepsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        presenter.loadStepsAdapter();
    }

    public void setIngredientsAdapter(IngredientsAdapter ingredientsAdapter) {
        ingredientsRecyclerView.setAdapter(ingredientsAdapter);
    }

    public void setStepsAdapter(StepsAdapter stepsAdapter) {
        stepsRecyclerView.setAdapter(stepsAdapter);
    }
}
