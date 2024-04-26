package com.example.shopappcomposefinal.domain.model

data class Product(
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val price: Int? = null,
    val discountPercentage: Float? = null,
    val rating: Float? = null,
    val stock: Int? = null,
    val brand: String? = null,
    val category: String? = null,
    val thumbnail: String? = null,
    var images: List<String>? = null
)


fun Product.toShopModelRoom(): ShopModelRoom {
    return ShopModelRoom(
        id = id ?: 0,
        nameProduct = title ?: "",
        price = price,
        category = category ?: "",
        rating = rating,
        discountPercentage = discountPercentage,
        image = images,
    )
}