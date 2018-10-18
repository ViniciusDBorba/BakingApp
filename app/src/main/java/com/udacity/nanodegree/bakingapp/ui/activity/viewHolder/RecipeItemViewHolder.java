package com.udacity.nanodegree.bakingapp.ui.activity.viewHolder;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.udacity.nanodegree.bakingapp.BuildConfig;
import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.RecipeDTO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recipe_image)
    ImageView recipeImage;
    @BindView(R.id.recipe_name)
    TextView recipeName;


    public RecipeItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(RecipeDTO item) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(itemView.getContext())
                .load(item.getImage())
                .apply(requestOptions)
                .into(recipeImage);

        recipeName.setText(item.getName());
    }
}
