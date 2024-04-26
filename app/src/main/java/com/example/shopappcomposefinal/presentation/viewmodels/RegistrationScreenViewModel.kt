package com.example.shopappcomposefinal.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopappcomposefinal.data.firebase.password_sign_in.FireBaseRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(
    private val firebaseRepository: FireBaseRepositoryImpl
) : ViewModel() {



    var registrationScreenState by mutableStateOf(RegistrationScreenState())
        private set

    fun changeRegistrationScreenState(state: RegistrationScreenState) {
        registrationScreenState = state
    }


    fun checkEmptyFields(isEmpty: () -> Unit) {
        if (registrationScreenState.name.isBlank()
            || registrationScreenState.email.isBlank()
            || registrationScreenState.password.isBlank()
            || registrationScreenState.confirmPassword.isBlank()
        ) {
            isEmpty()

        }
    }


    fun checkPassword(isChecked: () -> Unit) {
        if (registrationScreenState.password != registrationScreenState.confirmPassword) {
            isChecked()
        }
    }

    fun registrationAndToEnterFB() {
        viewModelScope.launch(Dispatchers.IO) {
            firebaseRepository.registrationAndToEnterFB(
                registrationScreenState.email,
                registrationScreenState.password,
                registrationScreenState.name,
                onFail = {},
                onSuccess = {}
            )
        }
    }

    fun signInToFireBase() {
        viewModelScope.launch(Dispatchers.IO) {
            firebaseRepository.signInToFireBase(
                registrationScreenState.email,
                registrationScreenState.password,
                onFail = {},
                onSuccess = {})
        }
    }



}

data class RegistrationScreenState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val visibilityPassword: Boolean = false
)

