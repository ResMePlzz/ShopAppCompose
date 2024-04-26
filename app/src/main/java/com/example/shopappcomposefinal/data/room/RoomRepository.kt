package com.example.shopappcomposefinal.data.room

import androidx.lifecycle.LiveData
import com.example.shopappcomposefinal.domain.model.ShopModelRoom
import javax.inject.Inject


class RoomRepository @Inject constructor(private val shopDAO: ShopDAO) {


    suspend fun insertFavoriteProduct(shopModelRoom: ShopModelRoom) {
        shopDAO.insertProduct(shopModelRoom)
    }

    suspend fun deleteFavoriteProduct(productId: Int) {
        shopDAO.deleteProduct(productId)
    }

    fun getAllProductRoom(): LiveData<List<ShopModelRoom>> {
        return shopDAO.getAllProductRoom()

    }

    suspend fun getProductByID(id: Int): ShopModelRoom? {
        return shopDAO.getProductByID(id)
    }

}