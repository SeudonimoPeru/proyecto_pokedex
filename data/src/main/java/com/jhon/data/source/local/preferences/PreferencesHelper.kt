package com.jhon.data.source.local.preferences

import android.content.SharedPreferences

class PreferencesHelper(private val prefs : SharedPreferences) {

     fun saveUser(user: String?) {
        user?.let { prefs.edit().putString(ConstansPreferences.KEY_USER, user).apply() }
    }

     fun getUser(): String {
        return prefs.getString(ConstansPreferences.KEY_USER, "")?:""
    }

    fun savePassword(user: String?) {
        user?.let { prefs.edit().putString(ConstansPreferences.KEY_PASSWORD, user).apply() }
    }

    fun getPassword(): String {
        return prefs.getString(ConstansPreferences.KEY_PASSWORD, "")?:""
    }
}