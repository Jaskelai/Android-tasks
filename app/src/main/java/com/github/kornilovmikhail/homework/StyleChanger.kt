package com.github.kornilovmikhail.homework

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object StyleChanger {
    fun getStyle(context: Context): Int {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val currentTheme = sharedPref.getString("style", "cmurrent")
        var themeId = R.style.AppTheme
        when (currentTheme) {
            "light" -> {
            }
            "special" -> themeId = R.style.Special
            "dark" -> themeId = R.style.Dark
        }

        return themeId
    }
}
