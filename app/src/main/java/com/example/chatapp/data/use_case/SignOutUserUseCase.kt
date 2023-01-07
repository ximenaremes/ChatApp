package com.example.chatapp.data.use_case

import com.example.chatapp.data.UserRepositoryImpl

class SignOutUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {

    suspend fun execute() {
        return repository.signOut()
    }
}
