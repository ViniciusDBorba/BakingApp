package com.udacity.nanodegree.bakingapp.ui.fragment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;
import com.udacity.nanodegree.bakingapp.ui.fragment.viewHolder.StepsViewHolder;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsViewHolder> {

    private final List<StepsDTO> steps;

    public StepsAdapter(List<StepsDTO> steps) {
        this.steps = steps;
    }

    @NonNull
    @Override
    public StepsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.step_recycler_item, viewGroup, false);
        return new StepsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StepsViewHolder stepsViewHolder, int i) {
        stepsViewHolder.bind(getItem(i));
    }

    private StepsDTO getItem(int i) {
        return steps.get(i);
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }
}
