package com.github.kornilovmikhail.homework.adapters;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kornilovmikhail.homework.utils.CityDiffUtilCallBack;
import com.github.kornilovmikhail.homework.R;
import com.github.kornilovmikhail.homework.entities.City;

import java.util.ArrayList;
import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityHolder> {

    private List<City> cities = new ArrayList<>();

    public CitiesAdapter(List<City> cities) {
        this.cities.addAll(cities);
    }

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new CityHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder cityHolder, int i) {
        cityHolder.bind(cities.get(i).getName(), cities.get(i).getPopulation(), cities.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CityHolder extends RecyclerView.ViewHolder {
        View cardView;
        TextView textNameView;
        ImageView imageView;
        TextView textCountryView;

        public CityHolder(View v) {
            super(v);
            cardView = v;
            textNameView = cardView.findViewById(R.id.card_title);
            imageView = cardView.findViewById(R.id.card_img);
            textCountryView = cardView.findViewById(R.id.card_population);
        }

        public void bind(String name, int population, int image) {
            imageView.setImageResource(image);
            textNameView.setText(name);
            textCountryView.setText("" + population);
        }
    }

    public void updateCityList(List<City> newCities) {
        CityDiffUtilCallBack diffCallback = new CityDiffUtilCallBack(cities, newCities);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        cities.clear();
        cities.addAll(newCities);
        diffResult.dispatchUpdatesTo(this);
    }
}
