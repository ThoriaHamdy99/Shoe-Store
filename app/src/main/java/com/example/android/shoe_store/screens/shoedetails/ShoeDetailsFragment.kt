package com.example.android.shoe_store.screens.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android.shoe_store.R
import com.example.android.shoe_store.databinding.FragmentShoeDetailsBinding
import com.example.android.shoe_store.models.Shoe
import com.example.android.shoe_store.screens.shoelist.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {

    private lateinit var shoeDetailsBinding: FragmentShoeDetailsBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    private lateinit var shoe: Shoe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        shoeDetailsBinding = FragmentShoeDetailsBinding.inflate(layoutInflater)
        shoe = Shoe("", 0.0, "", "", listOf(""))
        shoeDetailsBinding.shoesModel = shoe
        shoeDetailsBinding.saveButton.setOnClickListener {
            viewModel.addItem(shoe)
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentNavToShoeListFragmentNav())
        }

        shoeDetailsBinding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentNavToShoeListFragmentNav())
        }

        return shoeDetailsBinding.root
    }
}