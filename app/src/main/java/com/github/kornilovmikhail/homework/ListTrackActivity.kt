package com.github.kornilovmikhail.homework

import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_list_tracks.*

class ListTrackActivity : AppCompatActivity(), Callback, SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(StyleChanger.getStyle(applicationContext))
        setContentView(R.layout.activity_list_tracks)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = TrackAdapter(TracksRepository(this).getTracks() as List<Track>, this)
        recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val myToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(myToolbar)
        val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        prefs.registerOnSharedPreferenceChangeListener(this)
    }

    override fun callback(position: Int) {
        val intent = Intent(this@ListTrackActivity, MusicPlayerActivity::class.java)
        intent.putExtra(INTENT_CODE_POSITION, position)
        startActivity(intent)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, s: String) {
        recreate()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_settings -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, SettingsFragment()).commit()
                return true
            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    companion object {

        const val INTENT_CODE_POSITION = "Position"
    }
}
