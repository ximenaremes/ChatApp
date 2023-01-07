package com.example.chatapp.data.use_case

import com.example.chatapp.data.UserRepositoryImpl

class RegisterUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {

    suspend fun execute(name: String, email: String, password: String) {
        return repository.registerUserToFirebaseAuth(name, email, password)
    }
}