package com.github.kornilovmikhail.homework.utils;

import android.support.v7.util.DiffUtil;

import com.github.kornilovmikhail.homework.entities.City;

import java.util.List;

public class CityDiffUtilCallBack extends DiffUtil.Callback {
    private List<City> oldList;
    private List<City> newList;

    public CityDiffUtilCallBack(List<City> oldList, List<City> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).getId() == oldList.get(oldItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).equals(oldList.get(oldItemPosition));
    }
    
}
