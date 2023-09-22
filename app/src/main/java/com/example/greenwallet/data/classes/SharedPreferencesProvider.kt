package com.example.greenwallet.data.classes

import android.content.Context

class SharedPreferencesProvider(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)

    fun saveString(key: String, value: String){
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String?{
        return sharedPreferences.getString(key, null)
    }

    fun saveBoolean(key: String, value: Boolean){
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean{
        return sharedPreferences.getBoolean(key, false)
    }

    fun clear(){
        sharedPreferences.edit().clear().apply()
    }
}