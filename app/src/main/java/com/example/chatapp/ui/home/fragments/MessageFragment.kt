package com.example.chatapp.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatapp.databinding.FragmentMessageBinding
import com.example.chatapp.ui.base.BaseFragment

class MessageFragment : BaseFragment()  {

    lateinit var binding: FragmentMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMessageBinding.inflate(inflater,container,false)
        return binding.root
    }

}