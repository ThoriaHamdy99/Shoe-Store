package com.example.android.shoe_store.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.bumptech.glide.Glide
import com.example.android.shoe_store.R
import com.example.android.shoe_store.databinding.FragmentShoeListBinding
import com.example.android.shoe_store.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {
    private lateinit var shoeListBinding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        shoeListBinding = FragmentShoeListBinding.inflate(layoutInflater)

        setupMenue()
        setupLinearListView()

        shoeListBinding.goToDetailsFloatingBtn.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListNavFragmentToShoeDetailsNavFragment())
        }

        return shoeListBinding.root
    }

    private fun setupMenue() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(item: MenuItem): Boolean {
                if (item.itemId == R.id.login_nav_fragment) {
                    findNavController().popBackStack()
                    findNavController().navigateUp()

                }
                return item.onNavDestinationSelected(findNavController())
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setupLinearListView() {
        viewModel.shoeListLiveData.observe(viewLifecycleOwner, {
            it.forEachIndexed { index, shoe ->
                val itemView: ShoeItemBinding = ShoeItemBinding.inflate(layoutInflater)
                itemView.shoeName.text = shoe.name
                itemView.shoeCompany.text = shoe.company
                Glide.with(requireActivity())
                    .load(shoe.images[0])
                    .into(itemView.shoeImage)
                shoeListBinding.shoeListLinearLayout.addView(itemView.root, index)
            }
        })
    }
}