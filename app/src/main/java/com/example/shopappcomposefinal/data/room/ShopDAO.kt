package com.example.shopappcomposefinal.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shopappcomposefinal.domain.model.ShopModelRoom

@Dao
interface ShopDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(shopModelRoom: ShopModelRoom)

    @Query("DELETE FROM shop_table WHERE id = :id")
    suspend fun deleteProduct(id: Int)

    @Query("SELECT  * FROM shop_table WHERE id= :id")
    suspend fun getProductByID(id: Int): ShopModelRoom?

    @Query("SELECT * FROM shop_table")
    fun getAllProductRoom(): LiveData<List<ShopModelRoom>>
}