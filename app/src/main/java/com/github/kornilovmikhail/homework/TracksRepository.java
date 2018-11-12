package com.github.kornilovmikhail.homework;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TracksRepository {
    private List<Track> tracks;

    public TracksRepository(Context context) {
        tracks = new ArrayList<>();
        tracks.add(new Track(R.raw.kielobot_10_alles_leer_k_id_29,context.getResources().getResourceEntryName(R.raw.kielobot_10_alles_leer_k_id_29)));
        tracks.add(new Track(R.raw.krackatoa_07_so_long_sapien,context.getResources().getResourceEntryName(R.raw.krackatoa_07_so_long_sapien)));
        tracks.add(new Track(R.raw.phillip_gross_01_casablanca,context.getResources().getResourceEntryName(R.raw.phillip_gross_01_casablanca)));
        tracks.add(new Track(R.raw.scott_holmes_08_corporate_business,context.getResources().getResourceEntryName(R.raw.scott_holmes_08_corporate_business)));
        tracks.add(new Track(R.raw.simon_mathewson_04_container,context.getResources().getResourceEntryName(R.raw.simon_mathewson_04_container)));
    }

    public List getTracks() {
        return tracks;
    }

}
