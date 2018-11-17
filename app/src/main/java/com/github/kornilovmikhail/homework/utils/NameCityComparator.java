package com.github.kornilovmikhail.homework.utils;

import com.github.kornilovmikhail.homework.entities.City;

import java.util.Comparator;

public class NameCityComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city1.getName().compareTo(city2.getName());
    }
}
