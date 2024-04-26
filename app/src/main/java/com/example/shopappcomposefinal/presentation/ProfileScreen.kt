package com.example.shopappcomposefinal.presentation

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.model.UserData
import com.example.shopappcomposefinal.presentation.viewmodels.ProfileScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.SignInViewModel
import com.example.shopappcomposefinal.tools.BottomNavigation
import com.example.shopappcomposefinal.tools.CustomButtonProfile
import com.example.shopappcomposefinal.tools.ListProfileItemsState
import com.example.shopappcomposefinal.tools.ProfileItems

@SuppressLint("InvalidColorHexValue")
@Composable
fun ProfileScreen(
    sharedPreferences: SharedPreferences,
    profileScreenViewModel: ProfileScreenViewModel,
    navigator: NavHostController
) {

    val listProfileItemsState = ListProfileItemsState(profileScreenViewModel)
        .listProfileItemsState



    fun getUserData(): UserData {
        val userName = sharedPreferences.getString("userName", "")
        val profilePictureUrl = sharedPreferences.getString("profilePictureUrl", "")
        return UserData(userName, profilePictureUrl)
    }


    val listProfileItems by remember {
        mutableStateOf(listProfileItemsState)
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF9FF))
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {

            Spacer(modifier = Modifier.height(19.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )

                Text(
                    text = "Profile",
                    modifier = Modifier,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold700))
                )

                Spacer(modifier = Modifier.width(24.dp))

            }

            Spacer(modifier = Modifier.height(19.dp))

            Card(
                modifier = Modifier
                    .width(61.065.dp)
                    .height(61.06.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFC0C0C0)),
                shape = RoundedCornerShape(100.dp)
            ) {
                if (getUserData().profilePictureUrl != null) {
                    AsyncImage(
                        model = getUserData().profilePictureUrl,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { }
                    )
                }

            }

            Spacer(modifier = Modifier.height(5.94.dp))

            Text(
                text = "Change photo",
                modifier = Modifier,
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_medium500)),
                color = colorResource(R.color.annotationText)
            )

            Spacer(modifier = Modifier.height(17.dp))

            Text(
                text = getUserData().userName ?: "",
                modifier = Modifier,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold700)),
                color = colorResource(R.color.profileName)
            )

            Spacer(modifier = Modifier.height(36.dp))

            CustomButtonProfile(text = "Upload item")

            Spacer(modifier = Modifier.height(31.dp))



            LazyColumn() {
                items(listProfileItems) {
                    Column {
                        ProfileItems(
                            profileItemState = it,
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                    }

                }
            }


        }


    }

    BottomNavigation(navigator = navigator)

}