package com.example.android.shoe_store.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.shoe_store.models.Shoe

class ShoeListViewModel : ViewModel() {
    private lateinit var shoeListMutable: MutableLiveData<List<Shoe>>
    private lateinit var mutableList: MutableList<Shoe>
    val shoeListLiveData = shoeListMutable

    init {
        getData()
        initListData()
    }

    private fun getData() {
        shoeListMutable.postValue(
            mutableList
        )
    }

    private fun initListData() {
        mutableList = mutableListOf(
            Shoe("Overhaul 2.0 Lace-Up Shoes Black",
                37.0,
                "SKECHERS",
                "Soft woven knit mesh fabric upper",
                listOf("https://f.nooncdn.com/products/tr:n-t_80/v1634219602/N48095625V_1.webp")),
            Shoe("Defy All Day Training Shoes White",
                37.0,
                "NIKE",
                "Soft woven knit mesh fabric upper",
                listOf("https://f.nooncdn.com/products/tr:n-t_80/v1634219602/N48095625V_1.webp")),
            Shoe("Electron Street SoftFoam+ Sneakers Blue",
                37.0,
                "PUMA",
                "Soft woven knit mesh fabric upper",
                listOf("https://f.nooncdn.com/products/tr:n-t_80/v1637744972/N47089098V_1.webp")),
        )
    }

    fun addItem(shoe: Shoe) {
        mutableList.add(shoe)
        getData()
    }
}