package com.disizaniknem.thesocialnetwork.ui.auth.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.disizaniknem.thesocialnetwork.R
import com.disizaniknem.thesocialnetwork.other.EventObserver
import com.disizaniknem.thesocialnetwork.ui.auth.AuthViewModel
import com.disizaniknem.thesocialnetwork.ui.snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_register.*

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

        subscribeToObservers()

        btnRegister.setOnClickListener {
            viewModel.register(
                etEmail.text.toString(),
                etUsername.text.toString(),
                etPassword.text.toString(),
                etRepeatPassword.text.toString()
            )
        }

        tvLogin.setOnClickListener {
            if (findNavController().previousBackStackEntry != null) {
                findNavController().popBackStack()
            } else {
                findNavController().navigate(
                    RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                )
            }
        }
    }

    private fun subscribeToObservers() {
        viewModel.registerStatus.observe(viewLifecycleOwner, EventObserver(
            onError = {
                registerProgressBar.isVisible = false
                snackbar(it)
            },
            onLoading = {
                registerProgressBar.isVisible = true
            }
        ) {
            registerProgressBar.isVisible = false
            snackbar(getString(R.string.success_registration))
        })

    }
}