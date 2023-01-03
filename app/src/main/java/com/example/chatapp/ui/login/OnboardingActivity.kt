package com.example.chatapp.ui.login


import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityOnboardingBinding
import com.example.chatapp.ui.base.BaseActivity

class OnboardingActivity :BaseActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private val navController: NavController? by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_onboarding) as NavHostFragment?
        return@lazy navHostFragment?.navController
    }

}