package com.example.shopappcomposefinal.domain.model

data class ModelAllProducts(
    val products: List<Product>? = null,
    val total: Int? = null,
    val skip: Int? = null,
    val limit: Int? = null
)
