package com.example.android.shoe_store.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.shoe_store.R
import com.example.android.shoe_store.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        loginBinding = FragmentLoginBinding.inflate(layoutInflater)

        loginBinding.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginNavToWelcome())
        }

        return loginBinding.root
    }
}