package com.github.kornilovmikhail.homework.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.kornilovmikhail.homework.R;

public class PlaneFragment extends Fragment {

    public static final String NUM_KEY = "num_key";

    public static PlaneFragment newInstance(String name) {
        PlaneFragment planeFragment = new PlaneFragment();
        Bundle args = new Bundle();
        args.putString(NUM_KEY, name);
        planeFragment.setArguments(args);
        return planeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plane, container, false);
        TextView tvPlane = v.findViewById(R.id.tv_fragment_plane);
        tvPlane.setText(getArguments().getString(NUM_KEY));
        return v;
    }
}
