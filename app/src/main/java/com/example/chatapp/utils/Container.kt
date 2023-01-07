package com.example.chatapp.utils


import com.example.chatapp.data.UserRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Container() {

        private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        private var firebaseDBRef : DatabaseReference = FirebaseDatabase.getInstance().reference
//        private var firestoreDB : FirebaseFirestore = Firebase.firestore
        val userRepositoryImpl= UserRepositoryImpl( firebaseAuth,firebaseDBRef)
}