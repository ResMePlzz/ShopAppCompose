package com.example.shopappcomposefinal.tools

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.navigation.AllScreen

@Composable
fun BottomNavigation(navigator: NavHostController) {


    val onActiveItemHome = remember {
        mutableStateOf(false)
    }
    val onActiveItemFavorite = remember {
        mutableStateOf(false)
    }
    val onActiveItemCard = remember {
        mutableStateOf(false)
    }
    val onActiveItemMessage = remember {
        mutableStateOf(false)
    }

    val onActiveItemProfile = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = navigator.currentDestination?.route) {
        when (navigator.currentDestination?.route) {
            AllScreen.ProfileScreen.route -> {
                onActiveItemProfile.value = true
                onActiveItemHome.value = false
                onActiveItemFavorite.value = false
                onActiveItemCard.value = false
                onActiveItemMessage.value = false
            }

            AllScreen.MainScreen.route -> {
                onActiveItemHome.value = true
                onActiveItemFavorite.value = false
                onActiveItemCard.value = false
                onActiveItemMessage.value = false
                onActiveItemProfile.value = false
            }

            AllScreen.FavoriteScreen.route -> {
                onActiveItemFavorite.value = true
                onActiveItemCard.value = false
                onActiveItemMessage.value = false
                onActiveItemProfile.value = false
                onActiveItemHome.value = false
            }

            AllScreen.CardScreen.route -> {
                onActiveItemCard.value = true
                onActiveItemMessage.value = false
                onActiveItemProfile.value = false
                onActiveItemHome.value = false
                onActiveItemFavorite.value = false
            }

            AllScreen.ChatScreen.route -> {
                onActiveItemMessage.value = true
                onActiveItemProfile.value = false
                onActiveItemHome.value = false
                onActiveItemFavorite.value = false
                onActiveItemCard.value = false
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(63.dp)
                .align(Alignment.BottomCenter)
                .background(color = Color.White)
        ) {
            Spacer(modifier = Modifier.weight(4.5F))
            IconNavBar(
                icon = R.drawable.group_83,
                onActiveItem = onActiveItemHome,
                weight = 10.7F
            ) {
                navigator.navigate(AllScreen.MainScreen.route)

            }
            Spacer(modifier = Modifier.weight(9F))
            IconNavBar(
                icon = R.drawable.group_84,
                onActiveItem = onActiveItemFavorite,
                weight = 10.7F
            ) {
                navigator.navigate(AllScreen.FavoriteScreen.route)
            }
            Spacer(modifier = Modifier.weight(9F))
            IconNavBar(
                icon = R.drawable.group_85,
                onActiveItem = onActiveItemCard,
                weight = 10.7F
            ) {
                navigator.navigate(AllScreen.CardScreen.route)
            }
            Spacer(modifier = Modifier.weight(9F))
            IconNavBar(
                icon = R.drawable.group_86,
                onActiveItem = onActiveItemMessage,
                weight = 10.7F
            ) {
                navigator.navigate(AllScreen.ChatScreen.route)

            }
            Spacer(modifier = Modifier.weight(9F))
            IconNavBar(
                icon = R.drawable.group_126,
                onActiveItem = onActiveItemProfile,
                weight = 10.7F
            ) {
                navigator.navigate(AllScreen.ProfileScreen.route)
            }
            Spacer(modifier = Modifier.weight(4.5F))
        }
    }


}


@Composable
fun RowScope.IconNavBar(
    icon: Int, onActiveItem: MutableState<Boolean>,
    weight: Float, onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .weight(weight)
            .aspectRatio(1f)
    ) {


        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ellipse_18),
            contentDescription = "",
            tint = Color(0xFFEEEFF4),
            modifier = Modifier
                .alpha(if (onActiveItem.value) 1f else 0f)
                .fillMaxSize()
        )

        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = "",
            tint = if (onActiveItem.value) Color(0xFF737297) else Color(0xFF909090),
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    onClick()
                }

        )


    }
}