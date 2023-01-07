package com.example.chatapp.ui.login.viewModel

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.chatapp.data.UserRepositoryImpl
import com.example.chatapp.data.use_case.RegisterUserUseCase
import com.example.chatapp.ui.base.BaseViewModel
import com.example.chatapp.utils.Constants
import kotlinx.coroutines.launch


class SignUpFragmentViewModel(
    private val userRepositoryImpl: UserRepositoryImpl
) : BaseViewModel() {


    private var registerUserUseCase: RegisterUserUseCase = RegisterUserUseCase(userRepositoryImpl)


    fun registerUser(name: String, email: String, password: String){
        viewModelScope.launch {
            registerUserUseCase.execute(name, email, password)
        }
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


    class SignUpFragmentViewModelFactory(
        private val userRepositoryImpl:UserRepositoryImpl
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return SignUpFragmentViewModel(userRepositoryImpl) as T        }
    }
}