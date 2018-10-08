package com.github.kornilovmikhail.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {
    public static final Planet[] planets = {new Planet("Mercury", "First planet in " +
            "solar system", R.drawable.ic_planet_mercury), new Planet("Venus", "Second" +
            "planet in solar system", R.drawable.ic_planet_venus), new Planet("Earth",
            "Third planet in solar system", R.drawable.ic_planet_earth), new Planet("Mars",
            "Fourth planet in solar system", R.drawable.ic_planet_mars), new Planet("Jupiter",
            "Fifth planet in solar system", R.drawable.ic_planet_jupiter)};

    private Callback callback;

    public PlanetAdapter(Context context) {
        callback = (Callback) context;
    }

    public class PlanetHolder extends RecyclerView.ViewHolder {
        View item;
        ImageView imageView;
        TextView textView;


        public PlanetHolder(View v, Context context) {
            super(v);
            item = v;
        }

        public void bind(String name, int image) {
            imageView = item.findViewById(R.id.list_image);
            imageView.setImageResource(image);
            textView = item.findViewById(R.id.list_text);
            textView.setText(name);
            item.setOnClickListener(new View.OnClickListener() {
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PlanetHolder(v, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder planetHolder, int i) {
        planetHolder.bind(planets[i].getName(), planets[i].getImage());
    }

    @Override
    public int getItemCount() {
        return planets.length;
    }
}
