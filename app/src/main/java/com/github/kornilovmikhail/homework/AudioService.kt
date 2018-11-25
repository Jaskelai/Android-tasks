package com.github.kornilovmikhail.homework

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class AudioService : Service() {

    private var position = 0

    private var mediaPlayer: MediaPlayer? = null

    inner class TrackBinder : Binder() {
        internal val service: AudioService
            get() = this@AudioService
    }

    fun updateState(tracks: List<Track>, position: Int) {
        this.position = position
        mediaPlayer = MediaPlayer.create(this, tracks[position].id)
        mediaPlayer?.setOnCompletionListener {
            if (position == tracks.size - 1) {
                this.position = 0
            } else {
                this.position++
            }
            mediaPlayer = MediaPlayer.create(this, tracks[this.position].id)
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return TrackBinder()
    }

    override fun onUnbind(intent: Intent): Boolean {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        return false
    }

    fun pausePlayTrack() {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
        } else {
            mediaPlayer?.start()
        }
    }

    fun stopTrack() {
        mediaPlayer?.stop()
    }
}
