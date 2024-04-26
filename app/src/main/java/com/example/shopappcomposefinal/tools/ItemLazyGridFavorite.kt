package com.example.shopappcomposefinal.tools

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.domain.model.Product
import com.example.shopappcomposefinal.domain.model.ShopModelRoom
import com.example.shopappcomposefinal.domain.model.toShopModelRoom
import com.example.shopappcomposefinal.presentation.viewmodels.MainScreenViewModel


@SuppressLint("UnrememberedMutableState")
@Composable
fun ItemLazyGridFavorite(
    itemProduct: ShopModelRoom,
    mainScreenViewModel: MainScreenViewModel,
    onClick: () -> Unit
) {

    var isFavorite by mutableStateOf(false)

    Card(
        modifier = Modifier
            .width(174.dp)
            .height(221.dp),
        shape = RoundedCornerShape(11.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 7.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            AsyncImage(
                model = itemProduct.image?.get(0),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Card(
                modifier = Modifier
                    .padding(start = 7.dp, top = 7.dp)
                    .width(25.dp)
                    .height(25.dp),
                shape = RoundedCornerShape(100.dp),
                border = BorderStroke(width = 1.dp, color = Color(0xFFB9B9B9))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ellipse_26img),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.Unspecified
                )

            }


            Card(
                modifier = Modifier
                    .padding(start = 117.dp, top = 7.dp, end = 8.dp)
                    .width(49.dp)
                    .height(18.dp),
                shape = RoundedCornerShape(9.dp),
                colors = CardDefaults.cardColors(Color(0xFFF93A3A))
            ) {

                Text(
                    text = "${itemProduct.discountPercentage} off",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                    color = Color(0xFFFFFFFF)
                )


            }

            Card(
                modifier = Modifier
                    .padding(start = 10.dp, top = 121.dp)
                    .width(49.583.dp)
                    .height(17.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xD9C4C4C4D9))
            ) {
                Text(
                    text = itemProduct.category ?: "",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 9.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                    color = Color(0xFF070604)
                )

            }

            Text(
                text = itemProduct.nameProduct,
                modifier = Modifier
                    .padding(start = 9.dp, top = 144.dp)
                    .width(87.dp)
                    .height(36.dp),
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                color = Color(0xFFFFFFFF)
            )

            Text(
                text = itemProduct.price.toString(),
                modifier = Modifier
                    .padding(start = 10.dp, top = 192.dp)
                    .width(43.dp)
                    .height(12.dp),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                color = Color(0xFFFFFFFF)
            )

            Icon(

                if (!itemProduct.inFavorite) ImageVector.vectorResource(id = R.drawable.group_160)
                else ImageVector.vectorResource(id = R.drawable.group_160_red),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 102.dp, top = 183.dp)
                    .clickable {
                        onClick()
                        isFavorite = !isFavorite

                        mainScreenViewModel.getProductByID(itemProduct.id ?: 0) {
                            if (it == null) {
                                mainScreenViewModel.insertProductToDataBase(
                                    itemProduct
                                        .copy(inFavorite = isFavorite)
                                )
                            } else {
                                mainScreenViewModel.insertProductToDataBase(it.copy(inFavorite = isFavorite))
                            }
                        }
                    }

            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.group_148),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.padding(start = 135.dp, top = 179.dp).clickable {
                    mainScreenViewModel.getProductByID(itemProduct.id ?: 0) {
                        if ((it == null)) {
                            mainScreenViewModel.insertProductToDataBase(
                                itemProduct
                                    .copy(inCard = true)
                            )
                        }
                        else {
                            mainScreenViewModel.insertProductToDataBase(it.copy(inCard = true))
                        }
                    }
                },

            )


        }


    }

}