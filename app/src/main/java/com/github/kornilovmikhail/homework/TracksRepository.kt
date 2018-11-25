package com.github.kornilovmikhail.homework

import android.content.Context

import java.util.ArrayList

class TracksRepository(context: Context) {
    private val tracks: MutableList<Track>

    init {
        tracks = ArrayList()
        tracks.add(Track(R.raw.kielobot_10_alles_leer_k_id_29, context.resources.getResourceEntryName(R.raw.kielobot_10_alles_leer_k_id_29)))
        tracks.add(Track(R.raw.krackatoa_07_so_long_sapien, context.resources.getResourceEntryName(R.raw.krackatoa_07_so_long_sapien)))
        tracks.add(Track(R.raw.phillip_gross_01_casablanca, context.resources.getResourceEntryName(R.raw.phillip_gross_01_casablanca)))
        tracks.add(Track(R.raw.scott_holmes_08_corporate_business, context.resources.getResourceEntryName(R.raw.scott_holmes_08_corporate_business)))
        tracks.add(Track(R.raw.simon_mathewson_04_container, context.resources.getResourceEntryName(R.raw.simon_mathewson_04_container)))
    }

    fun getTracks(): List<Track> {
        return tracks
    }

}
