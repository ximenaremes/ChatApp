package com.example.chatapp.ui.home.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityHomeBinding
import com.example.chatapp.ui.base.BaseActivity
import com.example.chatapp.ui.home.viewModel.HomeActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: HomeActivityViewModel
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseDBRef : DatabaseReference = FirebaseDatabase.getInstance().reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNav()
    }

    private fun setupNav(){

        val navController = this.findNavController(R.id.nav_host_fragment)
        val navView: BottomNavigationView = findViewById(R.id.bottomNavView)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.welcomeFragment-> hideBottomNav()
                R.id.messageFragment-> hideBottomNav()
                R.id.signInFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNavView.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        binding.bottomNavView.visibility = View.GONE

    }

    private fun initViewModel() {
        val viewModelFactory: HomeActivityViewModel.HomeActivityViewModelFactory =
            HomeActivityViewModel.HomeActivityViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeActivityViewModel::class.java]
    }
}