package com.udacity.nanodegree.bakingapp.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.udacity.nanodegree.bakingapp.R;
import com.udacity.nanodegree.bakingapp.data.dto.StepsDTO;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StepContentFragment extends Fragment {


    private static final String SAVE_INSTANCE = "INSTANCE";
    private StepsDTO step;
    private SimpleExoPlayer player;

    @BindView(R.id.video_player)
    PlayerView playerView;
    @BindView(R.id.step_title)
    TextView stepTitle;
    @BindView(R.id.step_description)
    TextView stepDescription;
    @BindView(R.id.player_card)
    CardView playerCard;

    public StepContentFragment() {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putParcelable(SAVE_INSTANCE, step);

        super.onSaveInstanceState(outState);
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

    private void refresh(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.step = savedInstanceState.getParcelable(SAVE_INSTANCE);
        }

        if (step.getVideoURL() == null || step.getVideoURL().trim().isEmpty()) {
            if (playerCard != null)
                playerCard.setVisibility(View.GONE);
        } else {
            if (playerCard != null)
                playerCard.setVisibility(View.VISIBLE);

            player = ExoPlayerFactory.newSimpleInstance(
                    new DefaultRenderersFactory(getActivity()),
                    new DefaultTrackSelector(), new DefaultLoadControl());
            playerView.setVisibility(View.VISIBLE);
            Uri u = Uri.parse(step.getVideoURL());
            MediaSource source = new ExtractorMediaSource.Factory(
                    new DefaultHttpDataSourceFactory("exoplayer-codelab")).createMediaSource(u);

            playerView.setPlayer(player);
            player.prepare(source);
            player.setPlayWhenReady(false);
            player.seekTo(0, 0);
            player.prepare(source, true, false);
        }

        stepTitle.setText(step.getShortDescription());
        stepDescription.setText(step.getDescription());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_step_content, container, false);

        ButterKnife.bind(this, v);

        if (savedInstanceState != null)
            refresh(savedInstanceState);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        refresh(null);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.clearVideoSurface();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (player != null)
            player.stop();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (player != null)
            player.stop();
    }
}
