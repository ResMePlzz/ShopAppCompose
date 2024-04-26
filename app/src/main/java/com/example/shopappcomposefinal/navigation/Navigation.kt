package com.example.shopappcomposefinal.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shopappcomposefinal.domain.model.ShopModelRoom
import com.example.shopappcomposefinal.presentation.CardScreen
import com.example.shopappcomposefinal.presentation.ChatScreen
import com.example.shopappcomposefinal.presentation.DetailProductScreen
import com.example.shopappcomposefinal.presentation.FavoriteScreen
import com.example.shopappcomposefinal.presentation.MainScreen
import com.example.shopappcomposefinal.presentation.ProfileScreen
import com.example.shopappcomposefinal.presentation.RegistrationScreen
import com.example.shopappcomposefinal.presentation.SignInScreen
import com.example.shopappcomposefinal.presentation.viewmodels.ChatScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.DetailProductViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.FavoriteScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.GlobalViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.MainScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.ProfileScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.RegistrationScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.SignInViewModel

sealed class AllScreen(val route: String) {

    object SignInScreen : AllScreen(
        route = "SignInScreen"
    )

    object RegistrationScreen : AllScreen(
        route = "RegistrationScreen"
    )

    object ProfileScreen : AllScreen(
        route = "ProfileScreen"
    )

    object MainScreen : AllScreen(
        route = "MainScreen"
    )

    object DetailProductScreen : AllScreen(
        route = "DetailProductScreen"
    )

    object FavoriteScreen: AllScreen(
        route = "FavoriteScreen"
    )

    object CardScreen: AllScreen(
        route = "CardScreen"
    )

    object ChatScreen: AllScreen(
        route = "ChatScreen"
    )
}


@Composable
fun MyNavHost(
    navigator: NavHostController,
    signInViewModel: SignInViewModel,
    sharedPreferences: SharedPreferences,
    registrationScreenViewModel: RegistrationScreenViewModel,
    profileScreenViewModel: ProfileScreenViewModel,
    mainScreenViewModel: MainScreenViewModel,
    detailProductViewModel: DetailProductViewModel,
    globalViewModel: GlobalViewModel,
    favoriteScreenViewModel: FavoriteScreenViewModel,
    chatScreenViewModel: ChatScreenViewModel

) {

    NavHost(navController = navigator, startDestination = AllScreen.SignInScreen.route) {

        composable(route = AllScreen.SignInScreen.route) {
            SignInScreen(signInViewModel, navigator, globalViewModel)
        }
        composable(route = AllScreen.ProfileScreen.route) {
            ProfileScreen(
                sharedPreferences = sharedPreferences,
                profileScreenViewModel,
                navigator
            )
        }
        composable(route = AllScreen.RegistrationScreen.route) {
            RegistrationScreen(registrationScreenViewModel)
        }

        composable(route = AllScreen.MainScreen.route) {
            MainScreen(navigator, sharedPreferences, mainScreenViewModel, globalViewModel)
        }

        composable(route = AllScreen.DetailProductScreen.route) {
            DetailProductScreen(navigator, detailProductViewModel, globalViewModel)
        }

        composable(route = AllScreen.FavoriteScreen.route){
            FavoriteScreen(navigator, globalViewModel, favoriteScreenViewModel,mainScreenViewModel)
        }

        composable(route = AllScreen.CardScreen.route){
            CardScreen(navigator, globalViewModel, favoriteScreenViewModel,mainScreenViewModel)
        }

        composable(route = AllScreen.ChatScreen.route){
            ChatScreen(navigator,chatScreenViewModel)
        }

    }

}



