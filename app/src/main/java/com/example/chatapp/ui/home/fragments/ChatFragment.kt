package com.example.chatapp.ui.home.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.data.User
import com.example.chatapp.databinding.FragmentChatBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.home.adapter.RecyclerAdapterContacts
import com.example.chatapp.ui.home.viewModel.ChatFragmentViewModel
import com.example.chatapp.utils.Container
import com.example.chatapp.utils.MyApplication
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ChatFragment : BaseFragment() {

    private lateinit var binding: FragmentChatBinding
    lateinit var viewModel: ChatFragmentViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: RecyclerAdapterContacts
    private lateinit var userList: ArrayList<User>
    lateinit var appContainer: Container
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseDBRef: DatabaseReference = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appContainer = (requireActivity().application as MyApplication).myContainer
        initViewModel()
        initAdapter()
    }

    private fun initAdapter() {
        layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        userList = ArrayList()
        binding.recyclerViewChat.layoutManager = layoutManager
        adapter = RecyclerAdapterContacts(this, userList) {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_chatFragment_to_messageFragment)
            }
        }
        binding.recyclerViewChat.adapter = adapter
        addUserToAdapter()
    }

    private fun addUserToAdapter() {
        firebaseDBRef.child("user").addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for (postSnapshot in snapshot.children) {
                    val currentUser = postSnapshot.getValue(User::class.java)
                    if (firebaseAuth.currentUser?.uid != currentUser?.uid) {
                        userList.add(currentUser!!)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

    private fun initViewModel() {
        val viewModelFactory: ChatFragmentViewModel.ChatFragmentViewModelFactory =
            ChatFragmentViewModel.ChatFragmentViewModelFactory(appContainer.userRepositoryImpl)
        viewModel = ViewModelProvider(this, viewModelFactory)[ChatFragmentViewModel::class.java]
    }

}