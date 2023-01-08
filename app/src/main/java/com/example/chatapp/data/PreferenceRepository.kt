package com.example.chatapp.data

interface PreferenceRepository {

    fun saveUserName(name: String)
    fun getUserName() : String?

    fun saveUserEmail(email: String)
    fun getUserEmail(): String?

    fun saveIsUser(isUser: Boolean)
    fun getIsUser(): Boolean?
}