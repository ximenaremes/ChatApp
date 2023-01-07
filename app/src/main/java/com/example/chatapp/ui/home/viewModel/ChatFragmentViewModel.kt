package com.example.chatapp.ui.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.data.UserRepositoryImpl
import com.example.chatapp.ui.base.BaseViewModel


class ChatFragmentViewModel(
    val userRepositoryImpl: UserRepositoryImpl
) : BaseViewModel() {



    class ChatFragmentViewModelFactory(
        private val userRepositoryImpl: UserRepositoryImpl) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return ChatFragmentViewModel(userRepositoryImpl) as T
        }
    }
}