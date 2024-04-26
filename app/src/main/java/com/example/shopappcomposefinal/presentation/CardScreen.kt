package com.example.shopappcomposefinal.presentation

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.navigation.AllScreen
import com.example.shopappcomposefinal.presentation.viewmodels.FavoriteScreenViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.GlobalViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.MainScreenViewModel
import com.example.shopappcomposefinal.tools.BottomNavigation
import com.example.shopappcomposefinal.tools.ItemLazyGridFavorite

@Composable
fun CardScreen(
    navigator: NavHostController,
    globalViewModel: GlobalViewModel,
    favoriteScreenViewModel: FavoriteScreenViewModel,
    mainScreenViewModel: MainScreenViewModel
) {

    val listProductRoom = favoriteScreenViewModel.listProduct.observeAsState(listOf()).value.filter { it.inCard }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {

        Column(
            modifier = Modifier.fillMaxSize(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Card",
                fontSize = 26.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                color = colorResource(R.color.signInColor)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(listProductRoom) { itemProduct ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 11.dp)
                            .clickable {
                                //globalViewModel.changeProduct(itemProduct)
                                navigator.navigate(AllScreen.DetailProductScreen.route)
                            }
                    ) {
                        ItemLazyGridFavorite(itemProduct = itemProduct,mainScreenViewModel) {

                        }
                    }


                }
            }


        }

        BottomNavigation(navigator = navigator)
    }
}