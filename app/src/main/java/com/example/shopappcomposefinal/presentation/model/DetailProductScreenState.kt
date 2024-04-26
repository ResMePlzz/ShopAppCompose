package com.example.shopappcomposefinal.presentation.model

import com.example.shopappcomposefinal.domain.model.Product

data class DetailProductScreenState (
    val product: Product = Product(),
    val selectedImage: String = "",
)