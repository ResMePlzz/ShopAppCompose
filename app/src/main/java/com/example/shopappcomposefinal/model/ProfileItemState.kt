package com.example.shopappcomposefinal.model

import com.example.shopappcomposefinal.R

data class ProfileItemState(

    val iconCircle: Int = R.drawable.ellipse_25,
    val icon: Int,
    val text: String,
    val iconEnd: Int? = null,
    val textEnd: String? = null,
    val onClick:()-> Unit
)