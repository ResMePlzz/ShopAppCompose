package com.example.shopappcomposefinal.tools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopappcomposefinal.R


@Composable
fun CustomOutlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    text: String,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {

    Card(
        modifier = Modifier
            .width(289.dp)
            .height(29.dp),
        shape = RoundedCornerShape(15.dp),

        ) {

        MyOutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.signInTextField)),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            visualTransformation = visualTransformation,
            placeholder = {
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 7.dp, bottom = 7.dp),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium500)),
                    color = colorResource(R.color.hintTextColor)


                )
            },
        )
    }
}


@Composable
fun CustomOutlineTextFieldWithLogo(value: String, onValueChange: (String) -> Unit, text: String) {
    Card(
        modifier = Modifier
            .width(289.dp)
            .height(29.dp),
        shape = RoundedCornerShape(15.dp),

        ) {


        MyOutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .background(colorResource(R.color.signInTextField)),

            placeholder = {
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 7.dp, bottom = 7.dp),
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium500)),
                    color = colorResource(R.color.hintTextColor)


                )


            },

            )
        Spacer(modifier = Modifier.width(59.dp))

        Icon(
            painter = painterResource(R.drawable.eye_off),
            contentDescription = "",
            modifier = Modifier
                .width(15.dp)
                .height(15.dp)
                .padding(end = 15.dp)

        )


    }

}

@Composable
fun CustomSearchView(
    value: String,
    onValueChange: (String) -> Unit,
    text: String,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
) {
    Card(
        modifier = Modifier
            .width(289.dp)
            .height(29.dp),
        shape = RoundedCornerShape(15.dp),

        ) {

        MyOutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F6F6)),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            placeholder = {
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 7.dp, bottom = 7.dp),
                    fontSize = 9.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color(0xFF5B5B5B)


                )
            },
        )
    }

}