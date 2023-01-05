package com.example.chatapp.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatapp.databinding.FragmentSettingsBinding
import com.example.chatapp.ui.base.BaseFragment

class SettingsFragment : BaseFragment()  {

    lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }


}