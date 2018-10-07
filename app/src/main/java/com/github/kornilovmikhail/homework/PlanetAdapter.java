package com.github.kornilovmikhail.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {
    public static final Planet[] planets = {new Planet("Mercury", "First planet in " +
            "solar system", R.drawable.ic_planet_mercury), new Planet("Venus", "Second" +
            "planet in solar system", R.drawable.ic_planet_venus), new Planet("Earth",
            "Third planet in solar system", R.drawable.ic_planet_earth), new Planet("Mars",
            "Fourth planet in solar system", R.drawable.ic_planet_jupiter), new Planet("Jupiter",
            "Fifth planet in solar system", R.drawable.ic_planet_jupiter)};

    private Callback callback;

    public class PlanetHolder extends RecyclerView.ViewHolder {
        TextView tvPlanet;

        public PlanetHolder(TextView v) {
            super(v);
            tvPlanet = v;
        }

        public void bind(String name) {
            tvPlanet.setText(name);
            tvPlanet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != -1) {
                        callback.callback(position);
                    }
                }
            });
        }
    }

    @Override
    public PlanetAdapter.PlanetHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        callback = (Callback) parent.getContext();
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PlanetHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder planetHolder, int i) {
        planetHolder.bind(planets[i].getName());
    }

    @Override
    public int getItemCount() {
        return planets.length;
    }
}