package com.udacity.nanodegree.bakingapp.ui.activity.viewHolder;

import android.content.Intent;
import android.os.Parcelable;
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
import com.udacity.nanodegree.bakingapp.ui.activity.StepsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StepsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.step_thumb)
    ImageView stepThumb;
    @BindView(R.id.step_small_description)
    TextView smallDescription;
    private List<StepsDTO> steps = new ArrayList<>();
    private int position;

    public StepsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(List<StepsDTO> items, int i) {
        this.steps = items;
        this.position = i;
        StepsDTO item = items.get(i);
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

    @OnClick(R.id.step_card)
    public void onClickStep() {
        Intent i = new Intent(itemView.getContext(), StepsActivity.class);
        i.putParcelableArrayListExtra(StepsActivity.RECIPE_EXTRA, (ArrayList<? extends Parcelable>) steps);
        i.putExtra(StepsActivity.STEP_POSITION_EXTRA, position);
        itemView.getContext().startActivity(i);
    }
}
