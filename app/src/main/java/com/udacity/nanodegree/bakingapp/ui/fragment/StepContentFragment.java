package com.udacity.nanodegree.bakingapp.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


    private StepsDTO step;
    private SimpleExoPlayer player;

    @BindView(R.id.video_player)
    PlayerView playerView;

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

        player = ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(getActivity()),
                new DefaultTrackSelector(), new DefaultLoadControl());
        playerView.setVisibility(View.VISIBLE);
        Uri u = Uri.parse(step.getVideoURL());
        MediaSource source = new ExtractorMediaSource.Factory(
                new DefaultHttpDataSourceFactory("exoplayer-codelab")).createMediaSource(u);

        playerView.setPlayer(player);
        player.prepare(source);
        player.setPlayWhenReady(true);
        player.seekTo(0, 0);
        player.prepare(source, true, false);

    }
}
