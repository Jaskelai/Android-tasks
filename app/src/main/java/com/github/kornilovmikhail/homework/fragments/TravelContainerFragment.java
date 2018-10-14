package com.github.kornilovmikhail.homework.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.kornilovmikhail.homework.R;
import com.github.kornilovmikhail.homework.adapters.InfoFragmentPagerAdapter;

public class TravelContainerFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_travel_container, container, false);
        ViewPager viewPager = v.findViewById(R.id.view_pager);
        InfoFragmentPagerAdapter adapter = new InfoFragmentPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = v.findViewById(R.id.tab_layout_travel);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }

}
