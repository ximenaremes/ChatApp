package com.example.chatapp.data


import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlin.system.exitProcess


class UserRepositoryImpl(

    var firebaseAuth: FirebaseAuth,
    var firebaseDBRef: DatabaseReference,

    ) : UserRepository {

    override suspend fun registerUserToFirebaseAuth(name: String, email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)

            .addOnCompleteListener {
                Log.d(TAG, "Succes add user to firebase database")
                this.addUserToFirebaseDatabase(name, email, firebaseAuth.currentUser!!.uid)
            }
    }

    override fun addUserToFirebaseDatabase(name: String, email: String, uid: String) {
        firebaseDBRef.child("user").child(uid).setValue(User(name, email, uid))
    }

    override suspend fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { result ->
                Log.d(TAG, "Succes to login user")
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error to login user", exception)
                exitProcess(0)
            }
    }

    override suspend fun signOut() {
        firebaseAuth.signOut()
    }


}

