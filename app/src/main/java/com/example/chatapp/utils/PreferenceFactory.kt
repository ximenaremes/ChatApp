package com.example.chatapp.utils

import com.example.chatapp.data.PreferenceRepository
import com.example.chatapp.data.preferences.PreferenceRepositoryImpl

internal object PreferenceFactory {

    private val preferenceRepository: PreferenceRepository by lazy { return@lazy PreferenceRepositoryImpl }

    fun getPreference(): PreferenceRepository {
        return preferenceRepository
    }
}