package com.example.chatapp.utils

import android.app.Application

class MyApplication : Application(){

//    lateinit var context: Context
    lateinit var myContainer: Container

    override fun onCreate() {
        super.onCreate()
        myContainer= Container()

    }

}