package com.example.chatapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentSignUpBinding
import com.example.chatapp.ui.base.BaseFragment


class SignUpFragment : BaseFragment() {

    lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListener(view)
    }

    private fun setClickListener(view: View) {

//        binding.btnRegister.setOnClickListener{
//            Navigation.findNavController(view).navigate(R.id.action_signInOrSignUpFragment_to_signInFragment)
//        }

        binding.textLogin.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }

}








