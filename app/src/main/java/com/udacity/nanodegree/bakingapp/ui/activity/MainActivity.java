package com.udacity.nanodegree.bakingapp.ui.activity;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.ui.activity.adapter.MainRecipesAdapter;
import com.udacity.nanodegree.bakingapp.ui.activity.presenter.MainPresenter;
import com.udacity.nanodegree.bakingapp.ui.components.SaveInstanceRecyclerView;
import com.udacity.nanodegree.bakingapp.utils.InternetUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    @BindView(R.id.recipes_recycler)
    SaveInstanceRecyclerView recipesList;
    @BindView(R.id.recipes_progres)
    ContentLoadingProgressBar progressBar;
    public boolean loading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);

        recipesList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!InternetUtils.hasInternetConnection(this)) {
            Toast.makeText(this, getResources().getString(R.string.internet_connection), Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.loadRecipesAdapter();
    }

    public void toggleLoading() {
        if (loading) {
            progressBar.hide();
            progressBar.setVisibility(View.GONE);
        } else {
            progressBar.show();
            progressBar.setVisibility(View.VISIBLE);
        }

        loading = !loading;
    }

    public void setRecipesAdapter(MainRecipesAdapter mainRecipesAdapter) {
        recipesList.setAdapter(mainRecipesAdapter);

    }
}
