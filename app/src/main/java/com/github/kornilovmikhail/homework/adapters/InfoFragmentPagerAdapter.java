package com.github.kornilovmikhail.homework.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.github.kornilovmikhail.homework.fragments.CarFragment;
import com.github.kornilovmikhail.homework.fragments.PlaneFragment;
import com.github.kornilovmikhail.homework.fragments.TrainFragment;

import java.util.ArrayList;
import java.util.List;

public class InfoFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentTitleList = new ArrayList<>();

    public InfoFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        String carName = "Car";
        String trainName = "Train";
        String planeName = "Plane";
        CarFragment carFragment = CarFragment.newInstance(carName);
        TrainFragment trainFragment = TrainFragment.newInstance(trainName);
        PlaneFragment planeFragment = PlaneFragment.newInstance(planeName);
        fragmentList.add(carFragment);
        fragmentTitleList.add(carName);
        fragmentList.add(trainFragment);
        fragmentTitleList.add(trainName);
        fragmentList.add(planeFragment);
        fragmentTitleList.add(planeName);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
