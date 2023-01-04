package com.example.chatapp.ui.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.utils.Constants

class SignInFragmentViewModel() : ViewModel() {

    class SignInFragmentViewModelFactory() : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return SignInFragmentViewModel() as T
        }
    }

    fun validation(email: String, password: String): Int {

        if (email.isEmpty()) {
            return Constants.VALID_EMAIL
        } else if (password.isEmpty()) {
            return Constants.VALID_PASSWORD
        }
        return Constants.DEFAULT
    }
}