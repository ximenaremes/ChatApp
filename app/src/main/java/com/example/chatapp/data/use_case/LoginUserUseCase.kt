package com.example.chatapp.data.use_case

import com.example.chatapp.data.UserRepositoryImpl

class LoginUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {

    suspend fun execute(email: String, password: String) {
        return repository.loginUser(email,password)
    }
}