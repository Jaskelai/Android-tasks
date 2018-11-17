package com.github.kornilovmikhail.homework.entities;

import java.util.Objects;

public class City {
    private String name;
    private int photo;
    private int population;
    private int id;

    public City(String name, int population, int photo, int id) {
        this.name = name;
        this.photo = photo;
        this.population = population;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return photo == city.photo &&
                population == city.population &&
                id == city.id &&
                Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, photo, population, id);
    }
}
