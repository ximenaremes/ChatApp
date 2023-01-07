package com.example.chatapp.ui.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.ui.base.BaseViewModel

class OnboardingActivityViewModel () : BaseViewModel() {

        class OnboardingActivityViewModelFactory() : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return OnboardingActivityViewModel() as T

        }
    }
}