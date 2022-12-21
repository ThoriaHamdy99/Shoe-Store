package com.example.android.shoe_store.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.shoe_store.R
import com.example.android.shoe_store.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var welcomeBinding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        welcomeBinding = FragmentWelcomeBinding.inflate(layoutInflater)

        welcomeBinding.instructionsBtn.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionToInstruction())
        }

        return welcomeBinding.root
    }
}