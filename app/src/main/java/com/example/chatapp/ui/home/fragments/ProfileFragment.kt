package com.example.chatapp.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.data.PreferenceRepository
import com.example.chatapp.databinding.FragmentProfileBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.home.viewModel.ProfileFragmentViewModel
import com.example.chatapp.utils.AppChatApp
import com.example.chatapp.utils.Container
import com.example.chatapp.utils.PreferenceFactory

class ProfileFragment : BaseFragment()  {

    lateinit var binding: FragmentProfileBinding
    lateinit var viewModel: ProfileFragmentViewModel
    private lateinit var appContainer : Container
    private val preferenceRepository: PreferenceRepository by lazy {return@lazy PreferenceFactory.getPreference()}


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

        binding.textEmail.text = preferenceRepository.getUserEmail()
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