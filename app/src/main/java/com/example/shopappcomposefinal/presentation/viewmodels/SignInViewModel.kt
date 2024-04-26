package com.example.shopappcomposefinal.presentation.viewmodels

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopappcomposefinal.data.firebase.google_sign_in.GoogleSignInAuth
import com.example.shopappcomposefinal.data.firebase.password_sign_in.FireBaseRepositoryImpl
import com.example.shopappcomposefinal.model.UserData
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val sharedPreferences: SharedPreferences,
    val googleSignInClient: GoogleSignInClient,
    private val fireBaseRepository: FireBaseRepositoryImpl
) : ViewModel() {


    var signInScreenState by mutableStateOf(SignInScreenState())
        private set

    fun changeSignInScreenState(state: SignInScreenState) {
        signInScreenState = state
    }

    @SuppressLint("CommitPrefEdits")
    fun sharedPref(sharedPreferences: SharedPreferences, userData: UserData) {
        val editor = sharedPreferences.edit()
        editor.putString("userName", userData.userName)
        editor.putString("profilePictureUrl", userData.profilePictureUrl)
        editor.apply()
    }


    fun signInToFBWithPassword() {
        viewModelScope.launch(Dispatchers.IO) {
            fireBaseRepository.signInToFireBase(
                email = signInScreenState.login.toString(),
                password = signInScreenState.password.toString(),
                onSuccess = {},
                onFail = {})
        }
    }

    fun resultGoogleAuth(result: ActivityResult, onResultGoogleAuth: () -> Unit) {

        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            if (account != null) {
                val token = account.idToken
                GoogleSignInAuth.fireBaseAuthGoogle(
                    token ?: "",
                    firebaseAuth,
                    GoogleSignInAuth.getGoogleSignInOption()
                ) {
                    onResultGoogleAuth()
                }
                val userData = UserData(
                    userName = account.displayName ?: "",
                    profilePictureUrl = account.photoUrl.toString()
                )
                sharedPref(sharedPreferences = sharedPreferences, userData)

            }


        } catch (e: ApiException) {
            e.printStackTrace()
        }
    }


}

data class SignInScreenState(
    val login: String = "",
    val password: String = "",
    val visibilityPassword: Boolean = false
)

