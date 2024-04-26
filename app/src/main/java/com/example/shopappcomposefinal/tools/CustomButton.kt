package com.example.shopappcomposefinal.tools

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopappcomposefinal.R

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = {onClick() },
        modifier = Modifier
            .width(298.dp)
            .height(46.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.buttonStartScreen)),
        shape = RoundedCornerShape(15.dp),

        ) {

        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_bold700))
        )


    }
}

@Composable
fun CustomButtonProfile(text: String) {
    Button(
        onClick = { },
        modifier = Modifier
            .width(290.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.buttonStartScreen)),
        shape = RoundedCornerShape(15.dp),

        ) {

        Box(modifier = Modifier.fillMaxSize(1f)) {
            Icon(
                Icons.Filled.IosShare, contentDescription = "",
                modifier = Modifier
                    //.padding(start = 50.dp)
                    .align(Alignment.CenterStart)
            )

            Text(
                text = text,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold700)),
                modifier = Modifier.align(Alignment.Center)
            )

        }


    }
}