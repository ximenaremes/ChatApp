package com.example.chatapp.data.preferences

import android.content.SharedPreferences
import com.example.chatapp.utils.AppChatApp
import com.securepreferences.SecurePreferences

internal object PreferenceDataSource {
    const val USER_NAME = "user_name"
    const val USER_EMAIL = "user_email"
    const val IS_USER_LOGGED_IN = "user_logged"

    private val sharedPreferences: SharedPreferences = SecurePreferences(AppChatApp.instance.applicationContext)

    fun saveString(key: String, value: String) =
        sharedPreferences.edit().putString(key, value).apply()

    fun getString(key: String, defValue: String? = null): String? =
        sharedPreferences.getString(key, defValue)

    fun saveBoolean(key: String, value: Boolean) =
        sharedPreferences.edit().putBoolean(key, value).apply()

    fun getBoolean(key: String, defValue: Boolean = false) =
        sharedPreferences.getBoolean(key, defValue)
}