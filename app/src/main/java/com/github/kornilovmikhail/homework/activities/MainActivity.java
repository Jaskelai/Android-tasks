package com.github.kornilovmikhail.homework.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.github.kornilovmikhail.homework.R;
import com.github.kornilovmikhail.homework.fragments.CitiesFragment;
import com.github.kornilovmikhail.homework.fragments.TravelContainerFragment;
import com.github.kornilovmikhail.homework.fragments.TextFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnv;
    private TextFragment textFragment;
    private CitiesFragment citiesFragment;
    private TravelContainerFragment travelContainerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        transaction(textFragment);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bnv_name:
                        transaction(textFragment);
                        break;
                    case R.id.bnv_cities:
                        transaction(citiesFragment);
                        break;
                    case R.id.bnv_facts:
                        transaction(travelContainerFragment);
                }
                return true;
            }
        });
    }

    public void transaction(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_main, fragment);
        transaction.commit();
    }

    public void init() {
        bnv = findViewById(R.id.bnv_main);
        textFragment = new TextFragment();
        citiesFragment = new CitiesFragment();
        travelContainerFragment = new TravelContainerFragment();
    }

}
