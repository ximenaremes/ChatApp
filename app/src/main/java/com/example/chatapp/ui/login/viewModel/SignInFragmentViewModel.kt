package com.example.chatapp.ui.login.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.chatapp.data.UserRepositoryImpl

import com.example.chatapp.data.use_case.LoginUserUseCase
import com.example.chatapp.ui.base.BaseViewModel
import com.example.chatapp.utils.Constants
import kotlinx.coroutines.launch

class SignInFragmentViewModel(
    private val userRepositoryImpl: UserRepositoryImpl
) : BaseViewModel() {

    private var loginUserUseCase: LoginUserUseCase = LoginUserUseCase(userRepositoryImpl)
//    private val _viewState = MutableStateFlow(ViewState())
//    val viewState = _viewState.asStateFlow()

    fun loginUser(email: String, password: String){

        viewModelScope.launch {
            loginUserUseCase.execute(email,password)

        }
    }

//    data class ViewState(
//        var email : String? = null,
//        var password : String? = null
//    )

    fun validation(email: String, password: String): Int {

        if (email.isEmpty()) {
            return Constants.VALID_EMAIL
        } else if (password.isEmpty()) {
            return Constants.VALID_PASSWORD
        }
        return Constants.DEFAULT
    }

    class SignInFragmentViewModelFactory(
        private val userRepositoryImpl: UserRepositoryImpl) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return SignInFragmentViewModel(userRepositoryImpl) as T
        }
    }
}