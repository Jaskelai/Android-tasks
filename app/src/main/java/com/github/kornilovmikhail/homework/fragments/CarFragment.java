package com.github.kornilovmikhail.homework.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.kornilovmikhail.homework.R;

public class CarFragment extends Fragment {

    public static final String KEY_NAME = "key_name";

    public static CarFragment newInstance(String name) {
        CarFragment carFragment = new CarFragment();
        Bundle args = new Bundle();
        args.putString(KEY_NAME, name);
        carFragment.setArguments(args);
        return carFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_car, container, false);
        TextView tvCar = v.findViewById(R.id.tv_fragment_car);
        tvCar.setText(getArguments().getString(KEY_NAME));
        return v;
    }
}
