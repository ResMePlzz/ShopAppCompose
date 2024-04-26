package com.example.shopappcomposefinal.presentation

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.domain.model.ShopModelRoom
import com.example.shopappcomposefinal.domain.model.toShopModelRoom
import com.example.shopappcomposefinal.model.UserData
import com.example.shopappcomposefinal.navigation.AllScreen
import com.example.shopappcomposefinal.presentation.viewmodels.FavoriteScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.GlobalViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.MainScreenViewModel
import com.example.shopappcomposefinal.tools.BottomNavigation
import com.example.shopappcomposefinal.tools.CustomSearchView
import com.example.shopappcomposefinal.tools.SaleLazyRowItem


@SuppressLint("PrivateResource")
@Composable
fun MainScreen(
    navigator: NavHostController,
    sharedPreferences: SharedPreferences,
    mainScreenViewModel: MainScreenViewModel,
    globalViewModel: GlobalViewModel,
) {

    fun getUserData(): UserData {
        val userName = sharedPreferences.getString("userName", "")
        val profilePictureUrl = sharedPreferences.getString("profilePictureUrl", "")
        return UserData(userName, profilePictureUrl)
    }


    val listProduct = mainScreenViewModel.allProducts.products

    val listCategory = mainScreenViewModel.allCategory


    val searchTextState: MutableState<String> = remember {
        mutableStateOf("")
    }



    LaunchedEffect(key1 = true) {
        mainScreenViewModel.getProductOfCategory(category = "smartphones", onFail = {})
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {

        Spacer(modifier = Modifier.height(9.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.align_justify),
                contentDescription = "", modifier = Modifier
                    .padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.width(63.dp))

            Text(
                text = "Trade by", modifier = Modifier,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold700))
            )
            Text(
                text = " bata", modifier = Modifier,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold700)),
                color = Color(0xFF4E55D7)
            )
            Spacer(modifier = Modifier.width(52.dp))


            Card(
                modifier = Modifier
                    .padding(end = 47.07.dp)
                    .width(31.927.dp)
                    .height(30.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFC0C0C0)),
                shape = RoundedCornerShape(100.dp),
                border = BorderStroke(1.dp, color = Color(0xFF4E4D4D))
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


        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Location",
                modifier = Modifier.padding(start = 288.dp, top = 7.dp),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = Color(0xFF5B5B5B)
            )

            Spacer(modifier = Modifier.width(2.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.vector_arrow),
                contentDescription = "",
                modifier = Modifier.padding(top = 13.2.dp)
            )
        }

        Spacer(modifier = Modifier.height(9.dp))
        Card(
            modifier = Modifier
                .width(262.dp)
                .height(24.dp)
        ) {

            CustomSearchView(
                value = searchTextState.value,
                onValueChange = { inputText -> searchTextState.value = inputText },
                text = "What are you looking for ?",
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.spacer),
                        contentDescription = ""
                    )
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(R.drawable.search),
                        contentDescription = ""
                    )
                }

            )
        }

        Spacer(modifier = Modifier.height(17.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(15.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.group_132),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.clickable {
                    mainScreenViewModel.getProductOfCategory(category = "smartphones") {

                    }
                }
            )
            Spacer(modifier = Modifier.width(21.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.group_133),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.clickable {
                    mainScreenViewModel.getProductOfCategory(category = "mens-watches") {

                    }
                }

            )

            Spacer(modifier = Modifier.width(20.89.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.group_130),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.clickable {
                    mainScreenViewModel.getProductOfCategory(category = "laptops") {

                    }
                }

            )
            Spacer(modifier = Modifier.width(16.78.dp))


            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.group_131),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.clickable {
                    mainScreenViewModel.getProductOfCategory(category = "automotive") {

                    }
                }


            )
            Spacer(modifier = Modifier.width(17.22.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.group_139),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.clickable {
                    mainScreenViewModel.getProductOfCategory(category = "furniture") {

                    }
                }

            )
            Spacer(modifier = Modifier.width(17.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.group_138),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 14.46.dp)
                    .clickable {
                        mainScreenViewModel.getProductOfCategory(category = "womens-dresses") {
                        }
                    },
                tint = Color.Unspecified,


                )

        }
        Spacer(modifier = Modifier.height(11.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Phones", modifier = Modifier.padding(start = 21.dp),
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                color = Color(0xFFA6A7AB)
            )

            Spacer(modifier = Modifier.width(23.11.dp))


            Text(
                text = "Headphones", modifier = Modifier,
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                color = Color(0xFFA6A7AB)
            )

            Spacer(modifier = Modifier.width(24.dp))


            Text(
                text = "Games", modifier = Modifier,
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                color = Color(0xFFA6A7AB)
            )

            Spacer(modifier = Modifier.width(34.89.dp))


            Text(
                text = "Cars", modifier = Modifier,
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                color = Color(0xFFA6A7AB)
            )
            Spacer(modifier = Modifier.width(29.32.dp))


            Text(
                text = "Furniture", modifier = Modifier,
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                color = Color(0xFFA6A7AB)
            )

            Spacer(modifier = Modifier.width(35.11.dp))


            Text(
                text = "kids", modifier = Modifier.padding(end = 15.57.dp),
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                color = Color(0xFFA6A7AB)
            )
        }

        Spacer(modifier = Modifier.height(29.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Latest",
                modifier = Modifier
                    .padding(start = 11.dp)
                    .align(Alignment.Bottom),
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                color = Color(0xFF040402)
            )
            Spacer(modifier = Modifier.width(280.dp))

            Text(
                text = "View all", modifier = Modifier.padding(end = 11.dp),
                fontSize = 9.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                color = Color(0xFF808080)
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 170.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(listProduct ?: listOf()) { itemProduct ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 11.dp)
                        .clickable {
                            globalViewModel.changeProduct(itemProduct)
                            navigator.navigate(AllScreen.DetailProductScreen.route)
                        }
                ) {
                    SaleLazyRowItem(itemProduct = itemProduct, globalViewModel,mainScreenViewModel) {

                    }

                }


            }
            item(span = { GridItemSpan(2) }) {
                Spacer(modifier = Modifier.height(150.dp))
            }


        }


    }

    BottomNavigation(navigator)


}



