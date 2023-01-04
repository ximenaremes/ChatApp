package com.example.chatapp.ui.login.activity


import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityOnboardingBinding

import com.example.chatapp.ui.base.BaseActivity
import com.example.chatapp.ui.login.viewModel.OnboardingActivityViewModel

class OnboardingActivity :BaseActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    lateinit var viewModel: ViewModel

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

    private fun initViewModel() {
        val viewModelFactory: OnboardingActivityViewModel.OnboardingActivityViewModelFactory =
            OnboardingActivityViewModel.OnboardingActivityViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[OnboardingActivityViewModel::class.java]
    }

}