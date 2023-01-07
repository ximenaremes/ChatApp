package com.example.chatapp.ui.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.ui.base.BaseViewModel

class HomeActivityViewModel: BaseViewModel() {

    class HomeActivityViewModelFactory() : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return HomeActivityViewModel() as T

        }
    }
}