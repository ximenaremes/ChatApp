package com.example.chatapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentSignInBinding
import com.example.chatapp.ui.base.BaseFragment


class SignInFragment : BaseFragment() {

    lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener(view)

    }

    private fun setClickListener(view: View) {

//        binding.btnLogin.setOnClickListener{
//            Navigation.findNavController(view).navigate(R.id.action_signInOrSignUpFragment_to_signInFragment)
//        }

        binding.textRegister.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_signUpFragment)
        }

    }



}