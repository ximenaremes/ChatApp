package com.example.chatapp.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.example.chatapp.ui.base.BaseActivity
import com.example.chatapp.ui.login.OnboardingActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish()

    }
}