package com.github.kornilovmikhail.homework;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import java.util.List;

public class AudioService extends Service {

    private final IBinder mBinder = new TrackBinder();
    private MediaPlayer mediaPlayer;
    private List<Track> tracks;
    private int position;

    public class TrackBinder extends Binder {
        AudioService getService() {
            return AudioService.this;
        }
    }

    public void updateState(List<Track> tracks, int position) {
        this.tracks = tracks;
        this.position = position;
        mediaPlayer = MediaPlayer.create(this, tracks.get(position).getId());
        mediaPlayer.setOnCompletionListener(mediaPlayer -> {
            if (this.position == this.tracks.size() - 1) {
                this.position = 0;
            } else {
                this.position++;
            }
            mediaPlayer = MediaPlayer.create(this, this.tracks.get(this.position).getId());
        });
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        mediaPlayer.stop();
        mediaPlayer.release();
        return false;
    }

    public void pausePlayTrack() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    public void stopTrack() {
        mediaPlayer.stop();
    }
}
