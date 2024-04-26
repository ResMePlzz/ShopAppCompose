package com.example.shopappcomposefinal.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable


@Entity(tableName = "shop_table")
data class ShopModelRoom(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    @ColumnInfo(name = "nameProduct")
    val nameProduct: String = "",
    @ColumnInfo(name = "price")
    val price: Int? = 0,
    @ColumnInfo(name = "category")
    val category: String = "",
    @ColumnInfo(name = "discount")
    val discountPercentage: Float? = 1f,
    @ColumnInfo(name = "rating")
    val rating: Float? =1f,
    @ColumnInfo(name = "image")
    @TypeConverters(ConverterString::class)
    val image: List<String>? = listOf(),
    @ColumnInfo(name = "favorite")
    var inFavorite: Boolean = false,
    @ColumnInfo(name = "card")
    val inCard: Boolean = false

) : Serializable

class ConverterString() {
    @TypeConverter
    fun fromObject(obj: List<String>): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val objectOutputStream = ObjectOutputStream(byteArrayOutputStream)
        objectOutputStream.writeObject(obj)
        objectOutputStream.close()
        return byteArrayOutputStream.toByteArray()
    }

    // для чтения данных из БД
    @TypeConverter
    fun toObject(bytes: ByteArray): List<String> {
        val byteArrayInputStream = ByteArrayInputStream(bytes)
        val objectInputStream = ObjectInputStream(byteArrayInputStream)
        val obj = objectInputStream.readObject() as List<String>
        objectInputStream.close()
        return obj
    }


}