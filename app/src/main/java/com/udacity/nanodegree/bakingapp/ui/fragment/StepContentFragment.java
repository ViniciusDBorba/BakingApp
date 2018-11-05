package com.udacity.nanodegree.bakingapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StepContentFragment extends Fragment {


    private StepsDTO step;
    @BindView(R.id.video_player)
    PlayerView player;

    public StepContentFragment() {

    }

    public static StepContentFragment newInstance(StepsDTO step) {
        StepContentFragment fragment = new StepContentFragment();
        fragment.step = step;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_step_content, container, false);

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        TrackSelection.Factory trackSelectionFactory =   new RandomTrackSelection.Factory();
        TrackSelector trackSelector = new DefaultTrackSelector(trackSelectionFactory);
        SimpleExoPlayer simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector);

        player.setPlayer(simpleExoPlayer);
    }
}
