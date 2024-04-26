package com.example.shopappcomposefinal.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopappcomposefinal.data.retrofit.RetrofitClient
import com.example.shopappcomposefinal.data.room.RoomRepository
import com.example.shopappcomposefinal.domain.model.ModelAllProducts
import com.example.shopappcomposefinal.domain.model.ShopModelRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val roomRepository: RoomRepository
) : ViewModel() {


    var allProducts by mutableStateOf(ModelAllProducts())
        private set


    var allCategory by mutableStateOf(listOf(""))
        private set

    var allProductsRoom by mutableStateOf(listOf(""))

    var currentShopModelRoom by mutableStateOf<ShopModelRoom?>(null)
        private set


    fun getAllProductRoom(shopModelRoom: ShopModelRoom) {
        viewModelScope.launch(Dispatchers.IO) {

        }

    }

    fun insertProductToDataBase(shopModelRoom: ShopModelRoom) {
        viewModelScope.launch(Dispatchers.IO) {
            roomRepository.insertFavoriteProduct(shopModelRoom)
        }
    }


    fun getProductByID(id: Int, onSuccess: (ShopModelRoom?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            //currentShopModelRoom = roomRepository.getProductByID(id)
            onSuccess(roomRepository.getProductByID(id))
        }

    }


    fun getAllCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            allCategory = RetrofitClient.retrofitApi.getAllCategory()

        }
    }

    fun getProductOfCategory(category: String, onFail: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            //allProducts = RetrofitClient.retrofitApi.getProductOfCategory(category = category)
            RetrofitClient.retrofitApi.getProductOfCategory(category = category).enqueue(
                object : Callback<ModelAllProducts> {
                    override fun onResponse(
                        call: Call<ModelAllProducts>,
                        response: Response<ModelAllProducts>
                    ) {
                        when (response.code()) {
                            200 -> {
                                allProducts = response.body() ?: ModelAllProducts()
                            }

                            else -> onFail(response.code().toString())

                        }
                    }

                    override fun onFailure(call: Call<ModelAllProducts>, t: Throwable) {
                            onFail("No response")
                    }

                }
            )
        }
    }

}