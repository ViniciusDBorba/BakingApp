package com.udacity.nanodegree.bakingapp.ui.activity.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.step_thumb)
    ImageView stepThumb;
    @BindView(R.id.step_small_description)
    TextView smallDescription;

    public StepsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(StepsDTO item) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(itemView.getContext())
                .load(item.getThumbnailURL())
                .apply(requestOptions)
                .into(stepThumb);
        smallDescription.setText(item.getShortDescription());
    }
}
