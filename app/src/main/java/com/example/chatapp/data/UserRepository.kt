package com.example.chatapp.data


interface UserRepository {




    suspend fun registerUserToFirebaseAuth(name:String, email:String, password: String)
    fun addUserToFirebaseDatabase(name:String, email:String,uid:String)
    suspend fun loginUser(email: String,password: String)
    suspend fun signOut()

//    suspend fun getUserFromFirestore(email:String, password:String)


}