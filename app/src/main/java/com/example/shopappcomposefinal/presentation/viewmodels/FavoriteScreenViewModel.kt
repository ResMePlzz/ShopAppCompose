package com.example.shopappcomposefinal.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.shopappcomposefinal.data.room.RoomRepository
import com.example.shopappcomposefinal.domain.model.ShopModelRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteScreenViewModel @Inject constructor(roomRepository: RoomRepository) :
    ViewModel() {

    val listProduct: LiveData<List<ShopModelRoom>> = roomRepository.getAllProductRoom()


}