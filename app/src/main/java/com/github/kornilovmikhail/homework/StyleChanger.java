package com.github.kornilovmikhail.homework;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class StyleChanger {
    public static int getStyle(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String currentTheme = sharedPref.getString("style","cmurrent");
        int themeId = R.style.AppTheme;
        switch (currentTheme) {
            case "light":
                break;
            case "special":
                themeId = R.style.Special;
                break;
            case "dark":
                themeId = R.style.Dark;
                break;
        }

        return themeId;
    }
}
