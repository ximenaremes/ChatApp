package com.example.chatapp.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.FragmentChatBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.home.adapter.RecyclerAdapterContacts

class ChatFragment : BaseFragment() {

    private lateinit var binding: FragmentChatBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterContacts.ViewHolder>?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentChatBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter(){
       layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false )
        binding.recyclerViewChat.layoutManager=layoutManager
        adapter= RecyclerAdapterContacts()
        binding.recyclerViewChat.adapter = adapter
    }

}