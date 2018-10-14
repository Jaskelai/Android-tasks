package com.github.kornilovmikhail.homework.utils;

import com.github.kornilovmikhail.homework.R;
import com.github.kornilovmikhail.homework.entities.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CitiesRepository {

    public static List<City> sortByName() {
        List<City> cityList = getCitiesList();
        Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                return city1.getName().compareTo(city2.getName());
            }
        });
        return cityList;
    }

    public static List<City> sortByPopulation() {
        List<City> cityList = getCitiesList();
        Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                return city2.getPopulation() - city1.getPopulation();
            }
        });
        return cityList;
    }

    public static List<City> getCitiesList() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Moscow", 12506000, R.drawable.ic_moscow, 1));
        cities.add(new City("Kiev", 2804000, R.drawable.ic_kiev, 2));
        cities.add(new City("Berlin", 3470000, R.drawable.ic_berlin, 3));
        cities.add(new City("Paris", 2274000, R.drawable.ic_paris, 4));
        cities.add(new City("Madrid", 3166000, R.drawable.ic_madrid, 5));
        return cities;
    }
}
