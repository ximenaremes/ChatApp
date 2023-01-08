package com.example.chatapp.ui.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentSignUpBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.login.viewModel.SignUpFragmentViewModel
import com.example.chatapp.utils.AppChatApp
import com.example.chatapp.utils.Constants
import com.example.chatapp.utils.Container
import com.example.chatapp.utils.ErrorMessage


class SignUpFragment : BaseFragment() {

    lateinit var binding: FragmentSignUpBinding
    lateinit var viewModel: SignUpFragmentViewModel
    private lateinit var appContainer : Container

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appContainer=(requireActivity().application as AppChatApp).myContainer

        initViewModel()
        checkFocusableInputName()
        checkFocusableInputEmail()
        checkFocusableInputPassword()
        checkFocusableInputConfPassword()
        setClickListener(view)
    }

    private fun setClickListener(view: View) {

        binding.btnRegister.setOnClickListener{
            validateInputs(view)
        }

        binding.textLogin.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }
    private fun initViewModel() {
        val viewModelFactory: SignUpFragmentViewModel.SignUpFragmentViewModelFactory =
            SignUpFragmentViewModel.SignUpFragmentViewModelFactory(appContainer.userRepositoryImpl)
        viewModel = ViewModelProvider(this, viewModelFactory)[SignUpFragmentViewModel::class.java]
    }

    private fun validateInputs(view: View) {

        when(viewModel.validation(

            binding.textName.text.toString(),
            binding.textEmail.text.toString() ,
            binding.textPassword.text.toString(),
            binding.textConfPassword.text.toString())){

            Constants.VALID_NAME ->{
                with(binding) {
                    tvNameError.visibility = View.VISIBLE
                    circleErrorName.visibility=View.VISIBLE
                    tvNameError.text = context?.getString(ErrorMessage.VALID_NAME.stringResource)
                    tvNameError.setTextColor(resources.getColor(R.color.error,null))
                    textName.setBackgroundResource(R.drawable.field_error)
                    imageProfile.setColorFilter(resources.getColor(R.color.error,null))
                }
            }
            Constants.VALID_EMAIL ->{

                with(binding) {
                    tvEmailError.visibility = View.VISIBLE
                    circleErrorEmail.visibility=View.VISIBLE
                    tvEmailError.text = context?.getString(ErrorMessage.VALID_EMAIL.stringResource)
                    tvEmailError.setTextColor(resources.getColor(R.color.error,null))
                    textEmail.setBackgroundResource(R.drawable.field_error)
                    imageEmail.setColorFilter(resources.getColor(R.color.error,null))
                }
            }
            Constants.VALID_EMAIL_CHARACTERS ->{
                with(binding) {
                    tvEmailError.visibility = View.VISIBLE
                    circleErrorEmail.visibility=View.VISIBLE
                    tvEmailError.text = context?.getString(ErrorMessage.VALID_EMAIL_CHARACTERS.stringResource)
                    tvEmailError.setTextColor(resources.getColor(R.color.error,null))
                    textEmail.setBackgroundResource(R.drawable.field_error)
                    imageEmail.setColorFilter(resources.getColor(R.color.error,null))
                }

            }
            Constants.VALID_PASSWORD ->{
                with(binding) {
                    tvPassError.visibility = View.VISIBLE
                    circleErrorPassword.visibility=View.VISIBLE
                    tvPassError.text = context?.getString(ErrorMessage.VALID_PASSWORD.stringResource)
                    tvPassError.setTextColor(resources.getColor(R.color.error, null))
                    textPassword.setBackgroundResource(R.drawable.field_error)
                    imagePassword.setColorFilter(resources.getColor(R.color.error,null))
                }

            }
            Constants.VALID_PASSWORD_LENGTH ->{
                with(binding) {
                    tvPassError.visibility = View.VISIBLE
                    circleErrorPassword.visibility=View.VISIBLE
                    tvPassError.text = context?.getString(ErrorMessage.VALID_PASSWORD_LENGTH.stringResource)
                    tvPassError.setTextColor(resources.getColor(R.color.error, null))
                    textPassword.setBackgroundResource(R.drawable.field_error)
                    imagePassword.setColorFilter(resources.getColor(R.color.error,null))
                }

            }
            Constants.VALID_PASSWORD_CHARACTERS ->{
                with(binding) {
                    tvPassError.visibility = View.VISIBLE
                    circleErrorPassword.visibility=View.VISIBLE
                    tvPassError.text = context?.getString(ErrorMessage.VALID_PASSWORD_CHARACTERS.stringResource)
                    tvPassError.setTextColor(resources.getColor(R.color.error, null))
                    textPassword.setBackgroundResource(R.drawable.field_error)
                    imagePassword.setColorFilter(resources.getColor(R.color.error,null))
                }

            }
            Constants.VALID_CONFIRM_PASSWORD ->{
                with(binding) {
                    tvPassConfError.visibility = View.VISIBLE
                    circleErrorConfPassword.visibility=View.VISIBLE
                    tvPassConfError.text = context?.getString(ErrorMessage.VALID_CONFIRM_PASSWORD.stringResource)
                    tvPassConfError.setTextColor(resources.getColor(R.color.error, null))
                    textConfPassword.setBackgroundResource(R.drawable.field_error)
                    imageConfPassword.setColorFilter(resources.getColor(R.color.error,null))
                }

            }
            Constants.VALID_CONFIRM_PASSWORD_IDENTICAL ->{
                with(binding) {
                    tvPassConfError.visibility = View.VISIBLE
                    circleErrorConfPassword.visibility=View.VISIBLE
                    tvPassConfError.text = context?.getString(ErrorMessage.VALID_CONFIRM_PASSWORD_IDENTICAL.stringResource)
                    tvPassConfError.setTextColor(resources.getColor(R.color.error, null))
                    textConfPassword.setBackgroundResource(R.drawable.field_error)
                    imageConfPassword.setColorFilter(resources.getColor(R.color.error,null))
                }

            }
            Constants.DEFAULT -> {
                changeErrorsVisibility()
                viewModel.registerUser(
                    binding.textName.text.toString(),
                    binding.textEmail.text.toString() ,
                    binding.textPassword.text.toString() )
                Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_homeActivity)
            }

        }
    }

    private fun checkFocusableInputName(){
        binding.textName.setOnFocusChangeListener(View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {

                binding.textName.setBackgroundResource(R.drawable.field_focus)
                binding.imageProfile.setColorFilter(resources.getColor(R.color.border, null))
                changeErrorsVisibility()
            } else {
                binding.textName.setBackgroundResource(R.drawable.field)
                binding.imageProfile.setColorFilter(resources.getColor(R.color.border, null))
                changeErrorsVisibility()
            }
        })

    }

    private fun checkFocusableInputEmail(){
        binding.textEmail.setOnFocusChangeListener(View.OnFocusChangeListener { view, hasFocus ->
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
    private fun checkFocusableInputPassword(){
        binding.textPassword.setOnFocusChangeListener(View.OnFocusChangeListener { view, hasFocus ->
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
    private fun checkFocusableInputConfPassword(){
        binding.textConfPassword.setOnFocusChangeListener(View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {

                binding.textConfPassword.setBackgroundResource(R.drawable.field_focus)
                binding.imageConfPassword.setColorFilter(resources.getColor(R.color.border, null))
                changeErrorsVisibility()
            } else {

                binding.textConfPassword.setBackgroundResource(R.drawable.field)
                binding.imageConfPassword.setColorFilter(resources.getColor(R.color.border, null))
                changeErrorsVisibility()
            }
        })

    }

    private fun changeErrorsVisibility(){

        with(binding) {
            tvNameError.visibility = View.GONE
            circleErrorName.visibility=View.GONE

            tvEmailError.visibility = View.GONE
            circleErrorEmail.visibility=View.GONE

            tvPassError.visibility = View.GONE
            circleErrorPassword.visibility=View.GONE

            tvPassConfError.visibility = View.GONE
            circleErrorConfPassword.visibility=View.GONE
        }

    }

}








