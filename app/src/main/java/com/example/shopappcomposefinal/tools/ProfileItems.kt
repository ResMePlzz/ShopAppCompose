package com.example.shopappcomposefinal.tools

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.model.ProfileItemState

@Composable
fun ProfileItems(profileItemState: ProfileItemState) {
    Row(
        modifier = Modifier
            .width(298.dp)
            .height(40.dp)
            .clickable { profileItemState.onClick() }

    ) {

        Box(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        ) {


            Icon(
                imageVector = ImageVector.vectorResource(profileItemState.iconCircle),
                contentDescription = "",
                tint = Color(0xFFEEEFF4)
            )
            Icon(
                imageVector = ImageVector.vectorResource(profileItemState.icon),
                contentDescription = "", modifier = Modifier.align(Alignment.Center)
            )

        }
        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = profileItemState.text,
            modifier = Modifier.align(Alignment.CenterVertically),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium500)),
            color = Color(0xFF040402)
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {

            when {
                profileItemState.textEnd != null -> {
                    Text(
                        text = profileItemState.textEnd, fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_medium500)),
                        color = Color(0xFF040402)
                    )
                }

                profileItemState.iconEnd != null -> {
                    Icon(
                        imageVector = ImageVector.vectorResource(profileItemState.iconEnd),
                        contentDescription = "",
                    )
                }
            }
        }


    }
}

