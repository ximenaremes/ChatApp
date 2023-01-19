package com.example.chatapp.ui.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentSignInOrSignUpBinding
import com.example.chatapp.ui.base.BaseFragment


class SignInOrSignUpFragment : BaseFragment() {

    lateinit var binding: FragmentSignInOrSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding= FragmentSignInOrSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListener(view)
    }

    private fun setClickListener(view: View) {

        binding.textSignIn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signInOrSignUpFragment_to_signInFragment)
        }

        binding.btnSignUp.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signInOrSignUpFragment_to_signUpFragment)
        }

        binding.imageInfo.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id. action_signInOrSignUpFragment_to_popUpFragment)

        }

    }
}