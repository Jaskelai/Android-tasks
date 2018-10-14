package com.github.kornilovmikhail.homework.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.kornilovmikhail.homework.R;


public class TrainFragment extends Fragment {

    public static final String NUM_KEY = "num_key";

    public static TrainFragment newInstance(String name) {
        TrainFragment trainFragment = new TrainFragment();
        Bundle args = new Bundle();
        args.putString(NUM_KEY, name);
        trainFragment.setArguments(args);
        return trainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_train, container, false);
        TextView tvTrain = v.findViewById(R.id.tv_fragment_train);
        tvTrain.setText(getArguments().getString(NUM_KEY));
        return v;
    }


}
