package com.example.chatapp.utils

import android.app.Application

class AppChatApp : Application(){

//    lateinit var context: Context
    lateinit var myContainer: Container

    companion object{
        lateinit var instance: AppChatApp
    }

    override fun onCreate() {
        super.onCreate()
        myContainer= Container()
        instance = this

    }

}