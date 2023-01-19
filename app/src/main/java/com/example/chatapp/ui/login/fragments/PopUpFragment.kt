package com.example.chatapp.ui.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chatapp.databinding.FragmentPopUpBinding
import com.example.chatapp.ui.base.BaseFragment

class PopUpFragment : BaseFragment() {

    lateinit var binding: FragmentPopUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View{

        binding= FragmentPopUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListener(view)
    }

    private fun setClickListener(view: View) {

        binding.imageBack.setOnClickListener{
            view.let { it1 -> Navigation.findNavController(it1).popBackStack() }
        }
    }





}