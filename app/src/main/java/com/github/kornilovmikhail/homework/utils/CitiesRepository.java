package com.github.kornilovmikhail.homework.utils;

import com.github.kornilovmikhail.homework.R;
import com.github.kornilovmikhail.homework.entities.City;

import java.util.ArrayList;
import java.util.List;

public class CitiesRepository {

    public static List<City> getCitiesList() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 1));
        cities.add(new City("Kiev", 2804000, R.drawable.ic_kiev, 2));
        cities.add(new City("Berlin", 3470000, R.drawable.ic_berlin, 3));
        cities.add(new City("Paris", 2274000, R.drawable.ic_paris, 4));
        cities.add(new City("Madrid", 3166000, R.drawable.ic_madrid, 5));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 6));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 7));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 8));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 9));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 10));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 11));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 12));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 13));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 14));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 15));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 16));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 17));
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 18));
        return cities;
    }
}
