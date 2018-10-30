package com.udacity.nanodegree.bakingapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;
import com.udacity.nanodegree.bakingapp.ui.activity.presenter.RecipeDescriptionContentPresenter;
import com.udacity.nanodegree.bakingapp.ui.components.SaveInstanceRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDescriptionContentFragment extends Fragment {

    private RecipeDTO recipe;
    private RecipeDescriptionContentPresenter presenter;

    @BindView(R.id.ingredients_recycler)
    SaveInstanceRecyclerView instanceRecyclerView;
    @BindView(R.id.steps_recycler)
    SaveInstanceRecyclerView stepsRecyclerView;

    public RecipeDescriptionContentFragment() {
    }

    public static RecipeDescriptionContentFragment newInstance(RecipeDTO recipeDTO) {
        RecipeDescriptionContentFragment fragment = new RecipeDescriptionContentFragment();
        fragment.recipe = recipeDTO;
        fragment.presenter = new RecipeDescriptionContentPresenter(recipeDTO);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_description_content, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
