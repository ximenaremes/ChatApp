package com.example.chatapp.ui.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OnboardingActivityViewModel () : ViewModel() {

        class OnboardingActivityViewModelFactory() : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return OnboardingActivityViewModel() as T

        }
    }
}