package com.github.kornilovmikhail.homework;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MusicPlayerActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private ImageButton prevButton;
    private ImageButton pauseButton;
    private ImageButton nextButton;
    private TextView tvNameTrack;
    private AudioService audioService;
    private List<Track> tracks;
    private boolean isPlaying;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(StyleChanger.getStyle(getApplicationContext()));
        setContentView(R.layout.activity_player);
        tracks = new TracksRepository(this).getTracks();
        Intent intent = getIntent();
        position = intent.getIntExtra(ListTrackActivity.INTENT_CODE_POSITION, 0);
        tvNameTrack = findViewById(R.id.tv_track_name_player);
        tvNameTrack.setText(tracks.get(position).getName());
        prevButton = findViewById(R.id.btn_previous_track);
        prevButton.setOnClickListener(this);
        pauseButton = findViewById(R.id.btn_pause_play);
        pauseButton.setOnClickListener(this);
        nextButton = findViewById(R.id.btn_next_track);
        nextButton.setOnClickListener(this);
        Intent intentService = new Intent(this, AudioService.class);
        startService(intentService);
        bindService(intentService, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_previous_track:
                getPreviousTrack();
                break;
            case R.id.btn_pause_play:
                pausePlayTrack(view);
                break;
            case R.id.btn_next_track:
                getNextTrack();
                break;
        }
    }

    private void getPreviousTrack() {
        audioService.stopTrack();
        if (position == 0) {
            position = tracks.size() - 1;
        } else {
            position--;
        }
        tvNameTrack.setText(tracks.get(position).getName());
        audioService.updateState(tracks, position);
        if (isPlaying) {
            audioService.pausePlayTrack();
        }
    }

    private void pausePlayTrack(View view) {
        ImageView iv = (ImageView) view;
        if (!isPlaying) {
            if (view != null) {
                iv.setImageResource(R.drawable.ic_round_pause_black_48dp);
            }
            audioService.pausePlayTrack();
            isPlaying = true;
        } else {
            if (view != null) {
                iv.setImageResource(R.drawable.ic_round_play_arrow_black_48dp);
            }
            audioService.pausePlayTrack();
            isPlaying = false;
        }
    }

    private void getNextTrack() {
        audioService.stopTrack();
        if (position == tracks.size() - 1) {
            position = 0;
        } else {
            position++;
        }
        tvNameTrack.setText(tracks.get(position).getName());
        audioService.updateState(tracks, position);
        if (isPlaying) {
            audioService.pausePlayTrack();
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AudioService.TrackBinder audioServiceBinder = (AudioService.TrackBinder) iBinder;
        audioService = audioServiceBinder.getService();
        audioService.updateState(tracks, position);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        unbindService(this);
    }
}
