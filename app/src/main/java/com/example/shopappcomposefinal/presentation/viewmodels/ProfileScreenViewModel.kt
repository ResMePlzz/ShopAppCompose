package com.example.shopappcomposefinal.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopappcomposefinal.data.firebase.password_sign_in.FireBaseRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(private val fireBaseRepository: FireBaseRepositoryImpl) :
    ViewModel() {


    fun signOutToFB(onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            fireBaseRepository.signOutToFireBase()
            onSuccess()
        }

    }
}