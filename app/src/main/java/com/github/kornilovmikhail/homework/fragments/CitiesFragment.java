package com.github.kornilovmikhail.homework.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.kornilovmikhail.homework.R;
import com.github.kornilovmikhail.homework.adapters.CitiesAdapter;
import com.github.kornilovmikhail.homework.entities.City;
import com.github.kornilovmikhail.homework.utils.CitiesRepository;
import com.github.kornilovmikhail.homework.utils.NameCityComparator;
import com.github.kornilovmikhail.homework.utils.PopulationCityComparator;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Comparator;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;


public class CitiesFragment extends Fragment {

    private RecyclerView recyclerView;
    private CitiesAdapter adapter;
    private List<City> cities = CitiesRepository.getCitiesList();
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cities, container, false);
        setHasOptionsMenu(true);
        progressBar = v.findViewById(R.id.progressBar_cyclic);
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
                sortCityList(cities, new NameCityComparator());
                adapter.updateCityList(cities);
                recyclerView.scrollToPosition(0);
                return true;
            case R.id.action_cities_sort_pop:
                sortCityList(cities, new PopulationCityComparator());
                adapter.updateCityList(cities);
                recyclerView.scrollToPosition(0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sortCityList(List<City> oldCities, Comparator<City> comparator) {
        Flowable.fromIterable(oldCities)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(12)
                .sorted(comparator)
                .map(s -> new City(s.getName().concat(String.valueOf(s.getName().length())),
                        s.getPopulation(), s.getPhoto(), s.getId()))
                .doOnSubscribe(this::showLoading)
                .toList()
                .doOnSuccess(newCities -> adapter.updateCityList(newCities))
                .doAfterTerminate(this::hideLoading)
                .subscribe();
    }

    private void showLoading(Subscription subscription) {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    private void hideLoading() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

}