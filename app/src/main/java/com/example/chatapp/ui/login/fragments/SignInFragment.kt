package com.example.chatapp.ui.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.example.chatapp.R
import com.example.chatapp.data.PreferenceRepository
import com.example.chatapp.databinding.FragmentSignInBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.login.viewModel.SignInFragmentViewModel
import com.example.chatapp.utils.*


class SignInFragment : BaseFragment() {

    lateinit var binding: FragmentSignInBinding
    lateinit var viewModel: SignInFragmentViewModel
    private lateinit var appContainer: Container
    private val preferenceRepository: PreferenceRepository by lazy { return@lazy PreferenceFactory.getPreference() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appContainer = (requireActivity().application as AppChatApp).myContainer
        initViewModel()
        checkFocusableInputEmail()
        checkFocusableInputPassword()
        setClickListener(view)
//        initObservers()

    }

    private fun setClickListener(view: View) {

        binding.btnLogin.setOnClickListener {
            validateInputs(view)
        }

        binding.textRegister.setOnClickListener {
            findNavController(view).navigate(R.id.action_signInFragment_to_signUpFragment)
//            findNavController(view).navigate(R.id.action_signInFragment_to_homeActivity)
        }

    }

    private fun initViewModel() {
        val viewModelFactory: SignInFragmentViewModel.SignInFragmentViewModelFactory =
            SignInFragmentViewModel.SignInFragmentViewModelFactory(appContainer.userRepositoryImpl)
        viewModel = ViewModelProvider(this, viewModelFactory)[SignInFragmentViewModel::class.java]
    }

    private fun validateInputs(view: View) {

        when (viewModel.validation(

            binding.textEmail.text.toString(),
            binding.textPassword.text.toString()
        )) {

            Constants.VALID_EMAIL -> {
                with(binding) {
                    tvEmailError.visibility = View.VISIBLE
                    circleErrorEmail.visibility = View.VISIBLE
                    tvEmailError.text = context?.getString(ErrorMessage.VALID_EMAIL.stringResource)
                    tvEmailError.setTextColor(resources.getColor(R.color.error, null))
                    textEmail.setBackgroundResource(R.drawable.field_error)
                    imageEmail.setColorFilter(resources.getColor(R.color.error, null))
                }
            }


            Constants.VALID_PASSWORD -> {
                with(binding) {

                    tvPasswordError.visibility = View.VISIBLE
                    circleErrorPassword.visibility = View.VISIBLE
                    tvPasswordError.text =
                        context?.getString(ErrorMessage.VALID_PASSWORD.stringResource)
                    tvPasswordError.setTextColor(resources.getColor(R.color.error, null))
                    textPassword.setBackgroundResource(R.drawable.field_error)
                    imagePassword.setColorFilter(resources.getColor(R.color.error, null))
                }

            }
            Constants.DEFAULT -> {
                changeErrorsVisibility()
                viewModel.loginUser(
                    binding.textEmail.text.toString(),
                    binding.textPassword.text.toString()
                )
                //save user to sharedPrefs
                preferenceRepository.saveUserEmail(email = binding.textEmail.text.toString())
                preferenceRepository.saveIsUser(isUser = true)
                findNavController(view).navigate(R.id.action_signInFragment_to_homeActivity)

            }
        }
    }


//    private fun initObservers() {
//        viewLifecycleOwner.lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.viewState.collect {
//                    findNavController().navigate(R.id.action_signInFragment_to_homeActivity)
//                }
//            }
//        }
//    }

    private fun checkFocusableInputEmail() {

        binding.textEmail.setOnFocusChangeListener(View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {

                binding.textEmail.setBackgroundResource(R.drawable.field_focus)
                binding.imageEmail.setColorFilter(resources.getColor(R.color.border, null))
                changeErrorsVisibility()

            } else {
                binding.textEmail.setBackgroundResource(R.drawable.field)
                binding.imageEmail.setColorFilter(resources.getColor(R.color.border, null))
                changeErrorsVisibility()
            }
        })

    }

    private fun checkFocusableInputPassword() {

        binding.textPassword.setOnFocusChangeListener(View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {

                binding.textPassword.setBackgroundResource(R.drawable.field_focus)
                binding.imagePassword.setColorFilter(resources.getColor(R.color.border, null))
                changeErrorsVisibility()

            } else {
                binding.textPassword.setBackgroundResource(R.drawable.field)
                binding.imagePassword.setColorFilter(resources.getColor(R.color.border, null))
                changeErrorsVisibility()
            }
        })

    }

    private fun changeErrorsVisibility() {
        with(binding) {

            tvEmailError.visibility = View.GONE
            circleErrorEmail.visibility = View.GONE
            tvPasswordError.visibility = View.GONE
            circleErrorPassword.visibility = View.GONE
        }
    }


}


