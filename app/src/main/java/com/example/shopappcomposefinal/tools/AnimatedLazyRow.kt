package com.example.shopappcomposefinal.tools

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.domain.model.Product
import com.example.shopappcomposefinal.presentation.viewmodels.GlobalViewModel


@Composable
fun AnimatedLazyRow(product: Product, globalViewModel: GlobalViewModel) {


    var selected1 by remember {
        mutableStateOf(false)
    }

    var selected2 by remember {
        mutableStateOf(true)
    }
    var selected3 by remember {
        mutableStateOf(false)
    }

    val height1 = animateDpAsState(
        targetValue = if (selected1) 45.dp else 38.dp,
        animationSpec = tween(durationMillis = 500), label = ""
    )

    val width1 = animateDpAsState(
        targetValue = if (selected1) 83.dp else 66.dp,
        animationSpec = tween(durationMillis = 500), label = ""
    )

    val height2 = animateDpAsState(
        targetValue = if (selected2) 45.dp else 38.dp,
        animationSpec = tween(durationMillis = 500), label = ""
    )

    val width2 = animateDpAsState(
        targetValue = if (selected2) 83.dp else 66.dp,
        animationSpec = tween(durationMillis = 500), label = ""
    )
    val height3 = animateDpAsState(
        targetValue = if (selected3) 45.dp else 38.dp,
        animationSpec = tween(durationMillis = 500), label = ""
    )

    val width3 = animateDpAsState(
        targetValue = if (selected3) 83.dp else 66.dp,
        animationSpec = tween(durationMillis = 500), label = ""
    )



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp), horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {

        Box(
            modifier = Modifier
                .padding(horizontal = 2.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clickable {
                        globalViewModel.changeDetailProductScreenState(
                            globalViewModel.detailProductScreenState.copy(
                                selectedImage = product.images?.get(
                                    0
                                ) ?: ""
                            )
                        )
                        selected1 = true
                        selected2 = false
                        selected3 = false
                    }
                    .width(width1.value)
                    .height(height1.value),
                shape = RoundedCornerShape(6.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = if (selected1) 10.dp else 0.dp),

                ) {
                AsyncImage(
                    model = product.images?.get(0), contentDescription = "", modifier = Modifier
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )

            }
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 2.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clickable {
                        globalViewModel.changeDetailProductScreenState(
                            globalViewModel.detailProductScreenState.copy(
                                selectedImage = product.images?.get(
                                    1
                                ) ?: ""
                            )
                        )
                        selected1 = false
                        selected2 = true
                        selected3 = false
                    }
                    .width(width2.value)
                    .height(height2.value),
                shape = RoundedCornerShape(6.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = if (selected2) 10.dp else 0.dp),

                ) {
                AsyncImage(
                    model = product.images?.get(1),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 2.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clickable {
                        globalViewModel.changeDetailProductScreenState(
                            globalViewModel.detailProductScreenState.copy(
                                selectedImage = product.images?.get(
                                    2
                                ) ?: ""
                            )
                        )
                        selected1 = false
                        selected2 = false
                        selected3 = true
                    }
                    .width(width3.value)
                    .height(height3.value),
                shape = RoundedCornerShape(6.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = if (selected3) 10.dp else 0.dp),
            ) {
                AsyncImage(
                    model = product.images?.get(2), contentDescription = "", modifier = Modifier
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )
            }
        }

    }
}