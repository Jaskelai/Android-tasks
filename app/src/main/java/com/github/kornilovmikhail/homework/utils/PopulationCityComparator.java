package com.github.kornilovmikhail.homework.utils;

import com.github.kornilovmikhail.homework.entities.City;

import java.util.Comparator;

public class PopulationCityComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city2.getPopulation() - city1.getPopulation();
    }
}
