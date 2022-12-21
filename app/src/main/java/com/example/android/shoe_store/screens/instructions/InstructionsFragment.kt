package com.example.android.shoe_store.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.shoe_store.R
import com.example.android.shoe_store.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var instructionsBinding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        instructionsBinding = FragmentInstructionsBinding.inflate(layoutInflater)

        instructionsBinding.shoeListBtn.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionNavFragmentToShoeListNavFragment())
        }
        return instructionsBinding.root
    }
}