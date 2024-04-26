package com.example.shopappcomposefinal.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopappcomposefinal.domain.model.MessageModel

interface ChatRepository {


    fun addListener()


    fun readAllMessage(): LiveData<List<MessageModel>>


    suspend fun sendMessage(messageModel: MessageModel)

}