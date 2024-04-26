package com.example.shopappcomposefinal.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.domain.model.Product
import com.example.shopappcomposefinal.presentation.viewmodels.DetailProductViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.GlobalViewModel
import com.example.shopappcomposefinal.tools.AnimatedLazyRow
import com.example.shopappcomposefinal.tools.BottomNavigation


@Composable
fun DetailProductScreen(
    navigator: NavHostController, detailProductViewModel: DetailProductViewModel,
    globalViewModel: GlobalViewModel
) {


    LaunchedEffect(key1 = true) {
        val startImage = globalViewModel.product.images?.get(1) ?: ""

        globalViewModel.changeDetailProductScreenState(
            globalViewModel.detailProductScreenState.copy(
                selectedImage = startImage
            )
        )

    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.fillMaxSize()) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "",
                modifier = Modifier
                    .padding(start = 11.dp)
                    .clickable {
                        navigator.popBackStack()
                    }
            )

            Box(modifier = Modifier.width(349.dp)) {

                Card(
                    modifier = Modifier
                        .padding(top = 0.dp, start = 0.dp)
                        .width(328.dp)
                        .height(279.dp)
                ) {
                    AsyncImage(

                        model = globalViewModel.detailProductScreenState.selectedImage,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Card(
                    modifier = Modifier
                        .padding(start = 304.dp, top = 156.dp)
                        .width(42.dp)
                        .height(95.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE5E9EF)),
                    shape = RoundedCornerShape(14.dp)

                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.group_301),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 17.dp, start = 14.dp),
                        tint = Color(0xFF545589)
                    )
                    Spacer(modifier = Modifier.height(17.dp))
                    Divider(
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.82.dp)
                            .width(11.18.dp),
                        thickness = 1.dp,
                        color = Color(0xFF545589)
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.group_162),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 17.dp, start = 14.dp),
                        tint = Color(0xFF545589)
                    )
                }


            }

            Spacer(modifier = Modifier.height(35.dp))

            AnimatedLazyRow(globalViewModel.product, globalViewModel)

            Spacer(modifier = Modifier.height(21.dp))

            Row(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = globalViewModel.product.title ?: "", modifier = Modifier
                        .padding(start = 24.dp)
                        .width(186.dp)
                        .height(36.dp),
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                    color = Color(0xFF161826)
                )
                Spacer(modifier = Modifier.width(72.dp))

                Text(
                    text = "$ ${globalViewModel.product.price}", modifier = Modifier
                        .width(70.dp)
                        .height(17.dp),
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                    color = Color(0xFF161826),
                    textAlign = TextAlign.End
                )

                Spacer(modifier = Modifier.height(22.dp))

            }
            Text(
                text = globalViewModel.product.description ?: "",
                modifier = Modifier
                    .padding(start = 24.dp)
                    .width(231.dp)
                    .height(42.dp),
                fontSize = 9.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = Color(0xFF808080),
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.vector_star),
                    contentDescription = "",
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.width(0.49.dp))

                Text(
                    text = globalViewModel.product.rating.toString(),
                    fontSize = 9.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                    color = Color(0xFF161826),
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = "(4000 reviews)",
                    fontSize = 9.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color(0xFF808080),
                )


            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Color:",
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                color = Color(0xFF737373),
            )

            Spacer(modifier = Modifier.height(11.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp)
            ) {

                Card(
                    modifier = Modifier
                        .width(34.dp)
                        .height(26.dp),
                    shape = RoundedCornerShape(9.dp),
                    border = BorderStroke(width = 2.dp, color = Color(0xFFADADAD)),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {

                }
                Spacer(modifier = Modifier.width(14.dp))
                Card(
                    modifier = Modifier
                        .width(34.dp)
                        .height(26.dp),
                    shape = RoundedCornerShape(9.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFC4C4C4))
                ) {

                }
                Spacer(modifier = Modifier.width(14.dp))
                Card(
                    modifier = Modifier
                        .width(34.dp)
                        .height(26.dp),
                    shape = RoundedCornerShape(9.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF181726))
                ) {

                }


            }


            Spacer(modifier = Modifier.height(80.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(117.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF181726))
                ) {

                    Text(
                        modifier = Modifier.padding(start = 24.dp, top = 14.dp),
                        text = "Quantity:",
                        fontSize = 9.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium500)),
                        color = Color(0xFF737373),
                    )


                    Card(
                        modifier = Modifier
                            .padding(start = 24.dp, top = 38.dp)
                            .width(38.211.dp)
                            .height(22.dp),
                        colors = CardDefaults.cardColors(Color(0xFF4E55D7)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.vector_minus),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(top = 11.dp, start = 15.dp)
                        )


                    }

                    Card(
                        modifier = Modifier
                            .padding(start = 83.dp, top = 38.dp)
                            .width(38.211.dp)
                            .height(22.dp),
                        colors = CardDefaults.cardColors(Color(0xFF4E55D7)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_241),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(top = 7.dp, start = 16.dp)
                        )


                    }

                    Card(
                        modifier = Modifier
                            .padding(start = 182.dp, top = 19.dp)
                            .width(170.dp)
                            .height(44.dp),
                        colors = CardDefaults.cardColors(Color(0xFF4E55D7)),
                        shape = RoundedCornerShape(15.dp)
                    ) {

                        Text(
                            modifier = Modifier.padding(start = 89.dp, top = 16.dp),
                            text = "ADD TO CART",
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold600)),
                            color = Color.White,
                        )
                    }
                }

            }

            BottomNavigation(navigator)
        }
    }
}