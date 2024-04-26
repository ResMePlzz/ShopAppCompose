package com.example.shopappcomposefinal.presentation.viewmodels

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.shopappcomposefinal.data.shared_pref.SharedPreferenceManager
import com.example.shopappcomposefinal.domain.model.Product
import com.example.shopappcomposefinal.presentation.model.DetailProductScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GlobalViewModel @Inject constructor(
    private val sharedPreferenceManager: SharedPreferenceManager,
    private val sharedPreferences: SharedPreferences
) :
    ViewModel() {

    var product by mutableStateOf(Product())
        private set

    var detailProductScreenState by mutableStateOf(DetailProductScreenState())
        private set


    var imageProductState by mutableStateOf("")

    var changeColorIconState by mutableStateOf(false)
        private set

    val email = sharedPreferenceManager.email

    var providerAuth = sharedPreferenceManager.providerAuth

    var changeIconColor = sharedPreferenceManager.favoriteIcon


    fun changeProduct(newProduct: Product) {
        product = newProduct

    }

    fun changeIconColor(newColor: Boolean) {
        changeColorIconState = newColor

    }

    fun changeDetailProductScreenState(newState: DetailProductScreenState) {
        detailProductScreenState = newState
    }

    @SuppressLint("CommitPrefEdits")
    fun setFavorite(sharedPreferences: SharedPreferences, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("Color", value).apply()

    }

    fun getFavorite(sharedPreferences: SharedPreferences, value: Boolean): Boolean {
        return sharedPreferences.getBoolean("Color", value)
    }



}