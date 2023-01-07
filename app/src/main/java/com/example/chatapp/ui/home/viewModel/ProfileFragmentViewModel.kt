package com.example.chatapp.ui.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.chatapp.data.UserRepositoryImpl
import com.example.chatapp.data.use_case.SignOutUserUseCase
import com.example.chatapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ProfileFragmentViewModel(
    private val userRepositoryImpl: UserRepositoryImpl
) : BaseViewModel() {

    private var signOutUserUseCase: SignOutUserUseCase = SignOutUserUseCase(userRepositoryImpl)

    fun signOut(){
        viewModelScope.launch {
            signOutUserUseCase.execute()
        }
    }

    class ProfileFragmentViewModelFactory(
        private val userRepositoryImpl: UserRepositoryImpl
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return ProfileFragmentViewModel(userRepositoryImpl) as T
        }
    }
}