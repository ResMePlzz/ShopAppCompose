package com.example.shopappcomposefinal.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.shopappcomposefinal.domain.model.ConverterString
import com.example.shopappcomposefinal.domain.model.ShopModelRoom


@Database(entities = [ShopModelRoom::class], version = 1)
@TypeConverters(ConverterString::class)
abstract class DataBaseRoom : RoomDatabase() {

    abstract fun getShopDAO(): ShopDAO


}