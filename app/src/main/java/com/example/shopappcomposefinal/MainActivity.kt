package com.example.shopappcomposefinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.shopappcomposefinal.navigation.MyNavHost
import com.example.shopappcomposefinal.presentation.viewmodels.ChatScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.DetailProductViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.FavoriteScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.GlobalViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.MainScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.ProfileScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.RegistrationScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val sharedPreferences by lazy {
        getSharedPreferences("MyPrefs", MODE_PRIVATE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val signInViewModel = viewModel<SignInViewModel>()
            val profileScreenViewModel = viewModel<ProfileScreenViewModel>()
            val mainScreenViewModel = viewModel<MainScreenViewModel>()
            val detailProductViewModel = viewModel<DetailProductViewModel>()
            val globalViewModel = viewModel<GlobalViewModel>()
            val favoriteScreenViewModel = viewModel<FavoriteScreenViewModel>()
            val registrationScreenViewModel = viewModel<RegistrationScreenViewModel>()
            val chatScreenViewModel = viewModel<ChatScreenViewModel>()
            val navigate = rememberNavController()


            MyNavHost(
                navigator = navigate,
                signInViewModel,
                sharedPreferences,
                registrationScreenViewModel,
                profileScreenViewModel,
                mainScreenViewModel,
                detailProductViewModel,
                globalViewModel,
                favoriteScreenViewModel,
                chatScreenViewModel
            )

        }
    }
}

