package com.example.chatapp.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentWelcomeBinding
import com.example.chatapp.ui.base.BaseFragment

class WelcomeFragment : BaseFragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentWelcomeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener(view)

    }

    private fun setOnClickListener(view: View){
        binding.imageBtnGetStarted.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_chatFragment)

        }
    }
}