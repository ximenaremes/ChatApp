package com.example.chatapp.ui.login.viewModel

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.utils.Constants


class SignUpFragmentViewModel() : ViewModel() {

    class SignUpFragmentViewModelFactory() : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return SignUpFragmentViewModel() as T        }
    }

    fun validation(name: String, email: String, password: String, confirmPassword: String): Int {

        val passwordPattern= "^.*(?=.{4,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).*\$"

        if (name.isEmpty()) {
            return Constants.VALID_NAME
        } else if (email.isEmpty()) {
            return Constants.VALID_EMAIL
        }else if (!EMAIL_ADDRESS.matcher(email).matches()){
            return Constants.VALID_EMAIL_CHARACTERS
        } else if (password.isEmpty()) {
            return Constants.VALID_PASSWORD
        } else if (password.length <= 8){
            return Constants.VALID_PASSWORD_LENGTH
        } else if (!password.matches(passwordPattern.toRegex())){
            return Constants.VALID_PASSWORD_CHARACTERS
        } else if (confirmPassword.isEmpty()) {
            return Constants.VALID_CONFIRM_PASSWORD
        } else if (confirmPassword != password) {
            return Constants.VALID_CONFIRM_PASSWORD_IDENTICAL
        }
        return Constants.DEFAULT
    }

}