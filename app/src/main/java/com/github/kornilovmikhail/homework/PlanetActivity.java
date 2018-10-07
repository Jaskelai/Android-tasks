package com.github.kornilovmikhail.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetActivity extends AppCompatActivity implements Callback {
    private ImageView imageView;
    private TextView nameView;
    private TextView descriptionView;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        Intent intent = getIntent();
        position = intent.getIntExtra(MainActivity.INTENT_CODE, 0);
        Planet planet = PlanetAdapter.planets[position];
        imageView = findViewById(R.id.planet_image);
        imageView.setImageResource(planet.getImage());
        nameView = findViewById(R.id.planet_name);
        nameView.setText(planet.getName());
        descriptionView = findViewById(R.id.planet_description);
        descriptionView.setText(planet.getDescription());
    }

    @Override
    public void callback(int position) {
        this.position = position;
    }
}
