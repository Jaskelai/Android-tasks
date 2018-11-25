package com.github.kornilovmikhail.homework

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_player.*

class MusicPlayerActivity : AppCompatActivity(), View.OnClickListener, ServiceConnection {

    private var audioService: AudioService? = null
    private lateinit var tracks: List<Track>
    private var isPlaying: Boolean = false
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(StyleChanger.getStyle(applicationContext))
        setContentView(R.layout.activity_player)
        tracks = TracksRepository(this).getTracks() as List<Track>
        val intent = intent
        position = intent.getIntExtra(ListTrackActivity.INTENT_CODE_POSITION, 0)

        tv_track_name_player.text = tracks[position].name
        btn_previous_track.setOnClickListener(this)
        btn_pause_play.setOnClickListener(this)
        btn_next_track.setOnClickListener(this)
        val intentService = Intent(this, AudioService::class.java)
        startService(intentService)
        bindService(intentService, this, Context.BIND_AUTO_CREATE)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_previous_track -> getPreviousTrack()
            R.id.btn_pause_play -> pausePlayTrack(view)
            R.id.btn_next_track -> getNextTrack()
        }
    }

    private fun getPreviousTrack() {
        audioService?.stopTrack()
        if (position == 0) {
            position = tracks.size - 1
        } else {
            position--
        }
        tv_track_name_player.text = tracks[position].name
        audioService?.updateState(tracks, position)
        if (isPlaying) {
            audioService?.pausePlayTrack()
        }
    }

    private fun pausePlayTrack(view: View?) {
        val iv = view as ImageView?
        isPlaying = if (!isPlaying) {
            if (view != null) {
                iv?.setImageResource(R.drawable.ic_round_pause_black_48dp)
            }
            audioService?.pausePlayTrack()
            true
        } else {
            if (view != null) {
                iv?.setImageResource(R.drawable.ic_round_play_arrow_black_48dp)
            }
            audioService?.pausePlayTrack()
            false
        }
    }

    private fun getNextTrack() {
        audioService?.stopTrack()
        if (position == tracks.size - 1) {
            position = 0
        } else {
            position++
        }
        tv_track_name_player.text = tracks[position].name
        audioService?.updateState(tracks, position)
        if (isPlaying) {
            audioService?.pausePlayTrack()
        }
    }

    override fun onServiceConnected(componentName: ComponentName?, iBinder: IBinder?) {
        val audioServiceBinder = iBinder as AudioService.TrackBinder
        audioService = audioServiceBinder.service
        audioService?.updateState(tracks, position)
    }


    override fun onServiceDisconnected(componentName: ComponentName) {
        unbindService(this)
    }
}
