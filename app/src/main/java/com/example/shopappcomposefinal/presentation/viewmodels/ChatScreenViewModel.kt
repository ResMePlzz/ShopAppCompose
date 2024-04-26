package com.example.shopappcomposefinal.presentation.viewmodels

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopappcomposefinal.data.firebase.password_sign_in.FireBaseRepositoryImpl
import com.example.shopappcomposefinal.domain.model.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChatScreenViewModel @Inject constructor(
    private val repository: FireBaseRepositoryImpl,
    private val sharedPreferences: SharedPreferences
) :
    ViewModel() {


    val currentUser = repository.getCurrentUser()

    val readAllMessage = repository.readAllMessage()

    fun addListener() {
        repository.addListener()
    }

    fun getCurrentUserName(): String{
        return sharedPreferences.getString("userName", "" ) ?: ""
    }

    fun addMessage(messageModel: MessageModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.sendMessage(messageModel)
        }
    }


}