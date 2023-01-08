package com.example.chatapp.ui.home.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.data.PreferenceRepository
import com.example.chatapp.data.User
import com.example.chatapp.databinding.FragmentProfileBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.home.viewModel.ProfileFragmentViewModel
import com.example.chatapp.utils.AppChatApp
import com.example.chatapp.utils.Container
import com.example.chatapp.utils.PreferenceFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class ProfileFragment : BaseFragment()  {

    lateinit var binding: FragmentProfileBinding
    lateinit var viewModel: ProfileFragmentViewModel
    private lateinit var appContainer : Container
    private val preferenceRepository: PreferenceRepository by lazy {return@lazy PreferenceFactory.getPreference()}
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseDBRef : DatabaseReference = FirebaseDatabase.getInstance().reference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appContainer=(requireActivity().application as AppChatApp).myContainer
        initViewModel()
        setOnClikListener(view)
        initViews()
    }

    private fun initViews(){
        firebaseDBRef.child("user").child(firebaseAuth.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {

                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(User::class.java)
                    Log.d("user", "user=$user")
                    binding.textName.text = user?.name
                    binding.textEmail.text = user?.email
                }

                override fun onCancelled(error: DatabaseError) {
                }
            })

    }

    private fun setOnClikListener(view: View){
        binding.imageSignOut.setOnClickListener{
            viewModel.signOut()
            preferenceRepository.saveIsUser(isUser = false)
            Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_signInFragment)


        }
    }

    private fun initViewModel() {
        val viewModelFactory: ProfileFragmentViewModel.ProfileFragmentViewModelFactory =
            ProfileFragmentViewModel.ProfileFragmentViewModelFactory(appContainer.userRepositoryImpl)
        viewModel = ViewModelProvider(this, viewModelFactory)[ProfileFragmentViewModel::class.java]
    }


}