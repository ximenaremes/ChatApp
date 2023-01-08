package com.example.chatapp.ui.home.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.data.Message
import com.example.chatapp.databinding.FragmentMessageBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.home.adapter.RecyclerAdapterMessages
import com.example.chatapp.ui.home.viewModel.MessageFragmentViewModel
import com.example.chatapp.utils.AppChatApp
import com.example.chatapp.utils.Container
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MessageFragment : BaseFragment() {

    lateinit var binding: FragmentMessageBinding
    lateinit var viewModel: MessageFragmentViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: RecyclerAdapterMessages
    private lateinit var messageList: ArrayList<Message>
    private lateinit var appContainer: Container
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseDBRef: DatabaseReference = FirebaseDatabase.getInstance().reference

    var receiverRoom: String? = null
    var senderRoom: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()

        appContainer = (requireActivity().application as AppChatApp).myContainer

        val i = Intent()
        val name = i.getStringExtra("name")
//        val receiverUid = arguments?.getString("receiverUid")
        val receiverUid = i.getStringExtra("uid") //some problem with uid here!!!
        val senderUid = firebaseAuth.currentUser?.uid

        senderRoom = receiverUid + senderUid
        receiverRoom = senderUid + receiverUid

//        binding.textNameUser.text = name

//ADDING DATA FOR RECYCLERVIEW
        firebaseDBRef.child("chats").child(senderRoom!!).child("messages")
            .addValueEventListener(object : ValueEventListener {

                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(snapshot: DataSnapshot) {
                    messageList.clear()
                    for (postSnapshot in snapshot.children) {

                        val message = postSnapshot.getValue(Message::class.java)
                        messageList.add(message!!)

                    }
                    adapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })


// ADDING MESSAGES TO DATABASE
        binding.imageSend.setOnClickListener {
            val message = binding.editTextTextPersonName.text.toString()
            val messageObject = Message(message, senderUid)
            firebaseDBRef.child("chats").child(senderRoom!!).child("messages")
                .push()
                .setValue(messageObject)
                .addOnCanceledListener {
                    firebaseDBRef.child("chats").child(receiverRoom!!).child("messages")
                        .push()
                        .setValue(messageObject)
                }
            binding.editTextTextPersonName.setText("")

        }

        initViewModel()
        initAdapter()

    }

    private fun initAdapter() {
        layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        messageList = ArrayList()
        binding.recyclerViewMessage.layoutManager = layoutManager
        adapter = RecyclerAdapterMessages(this, messageList)
        binding.recyclerViewMessage.adapter = adapter

    }

    private fun initViewModel() {
        val viewModelFactory: MessageFragmentViewModel.MessageFragmentViewModelFactory =
            MessageFragmentViewModel.MessageFragmentViewModelFactory(appContainer.userRepositoryImpl)
        viewModel = ViewModelProvider(this, viewModelFactory)[MessageFragmentViewModel::class.java]
    }

    private fun initListeners() {
        binding.imageBack.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).popBackStack() }
        }
    }

    private fun initViews() {
        val chatWithName = arguments?.getString("ItemChatName") ?: ""
        Log.d("chat with...", "name=$chatWithName")
        binding.textNameUser.text = chatWithName
    }

}