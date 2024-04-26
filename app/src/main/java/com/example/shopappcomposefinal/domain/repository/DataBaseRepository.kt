package com.example.shopappcomposefinal.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopappcomposefinal.model.UserModel


interface DataBaseRepository {

    suspend fun registrationAndToEnterFB(
        email: String,
        password: String,
        name: String,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    )

    suspend fun signInToFireBase(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    )

    suspend fun signOutToFireBase()


    fun getCurrentUser():UserModel




}