package com.bada.widgetprac

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("numCups", Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String): String {
        return preferences.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String) {
        preferences.edit().putString(key, str).apply()
    }
}