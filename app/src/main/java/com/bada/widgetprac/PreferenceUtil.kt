package com.bada.widgetprac

import android.content.Context
import android.content.SharedPreferences
import com.bada.widgetprac.MyApplication.Companion.preferences
import java.text.SimpleDateFormat
import java.util.Date

class PreferenceUtil(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("numWater", Context.MODE_PRIVATE)

    fun getStringCups(date: Date, defValue: String = "0", ): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val key = formatter.format(date) + "_CUP"
        return preferences.getString(key, defValue).toString()
    }

    fun setStringCups(date: Date, str: String) {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val key = formatter.format(date) + "_CUP"
        preferences.edit().putString(key, str).apply()
    }

    fun getStringTums(date: Date, defValue: String = "0", ): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val key = formatter.format(date) + "_TUM"
        return preferences.getString(key, defValue).toString()
    }

    fun setStringTums(date: Date, str: String) {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val key = formatter.format(date) + "_TUM"
        preferences.edit().putString(key, str).apply()
    }

    fun getStringBots(date: Date, defValue: String = "0", ): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val key = formatter.format(date) + "_BOT"
        return preferences.getString(key, defValue).toString()
    }

    fun setStringBots(date: Date, str: String) {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val key = formatter.format(date) + "_BOT"
        preferences.edit().putString(key, str).apply()
    }
}