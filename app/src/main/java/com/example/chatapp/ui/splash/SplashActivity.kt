package com.example.chatapp.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.example.chatapp.data.PreferenceRepository
import com.example.chatapp.ui.base.BaseActivity
import com.example.chatapp.ui.home.activity.HomeActivity
import com.example.chatapp.ui.login.activity.OnboardingActivity
import com.example.chatapp.utils.PreferenceFactory


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private val preferenceRepository: PreferenceRepository by lazy { return@lazy PreferenceFactory.getPreference() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val intent = Intent(this, OnboardingActivity::class.java)
//        startActivity(intent)
        checkfirstRun()
        finish()

    }

    private fun checkfirstRun() {
        val isUser: Boolean? = preferenceRepository.getIsUser()

        if (isUser == true) {
            startNormal()
        } else {
            startWelcomePage()
        }
    }

    private fun startWelcomePage() {
        startActivity(Intent(this, OnboardingActivity::class.java))
    }

    private fun startNormal() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}