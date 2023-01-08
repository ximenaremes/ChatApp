package com.example.chatapp.data.preferences

import android.util.Log
import com.example.chatapp.data.PreferenceRepository

internal object PreferenceRepositoryImpl: PreferenceRepository {

    init {
        Log.d("prefs", "init prefs")
    }

    private val preferenceDataSource = PreferenceDataSource

    override fun saveUserName(name: String) {
        preferenceDataSource.saveString(PreferenceDataSource.USER_NAME, name)
    }

    override fun getUserName(): String? {
        return preferenceDataSource.getString(PreferenceDataSource.USER_NAME, "")
    }

    override fun saveUserEmail(email: String) {
        preferenceDataSource.saveString(PreferenceDataSource.USER_EMAIL, email)
    }

    override fun getUserEmail(): String? {
        return preferenceDataSource.getString(PreferenceDataSource.USER_EMAIL, "")
    }

    override fun saveIsUser(isUser: Boolean) {
        preferenceDataSource.saveBoolean(PreferenceDataSource.IS_USER_LOGGED_IN, isUser)
    }

    override fun getIsUser(): Boolean? {
        return preferenceDataSource.getBoolean(PreferenceDataSource.IS_USER_LOGGED_IN, defValue = false)
    }


}