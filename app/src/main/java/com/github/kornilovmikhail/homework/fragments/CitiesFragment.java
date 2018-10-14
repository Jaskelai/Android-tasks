package com.github.kornilovmikhail.homework.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.kornilovmikhail.homework.R;
import com.github.kornilovmikhail.homework.adapters.CitiesAdapter;
import com.github.kornilovmikhail.homework.utils.CitiesRepository;


public class CitiesFragment extends Fragment {

    private RecyclerView recyclerView;
    private CitiesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cities, container, false);
        setHasOptionsMenu(true);
        recyclerView = v.findViewById(R.id.rv_cities);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CitiesAdapter(CitiesRepository.getCitiesList());
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_cities, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cities_sort_name:
                adapter.updateCityList(CitiesRepository.sortByName());
                recyclerView.scrollToPosition(0);
                return true;
            case R.id.action_cities_sort_pop:
                adapter.updateCityList(CitiesRepository.sortByPopulation());
                recyclerView.scrollToPosition(0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}