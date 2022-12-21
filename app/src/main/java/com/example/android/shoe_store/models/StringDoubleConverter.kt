package com.example.android.shoe_store.models

import androidx.databinding.InverseMethod
import java.lang.Double

object StringDoubleConverter{

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double?): String {
        return value?.toString() ?: ""
    }

    @JvmStatic
    fun stringToDouble(value: String?): Double {
        return (value?.toDouble() ?: (0.0).toDouble()) as Double
    }
}