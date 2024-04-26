package com.example.shopappcomposefinal.tools

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.shopappcomposefinal.model.UserModel


@Composable
fun TitleTopBar (userModel: UserModel) {
    Row {
        Card(modifier = Modifier.size(40.dp), shape = RoundedCornerShape(100.dp)) {
            AsyncImage(model = userModel.userAvatar, contentDescription = "",
                contentScale = ContentScale.Crop)
        }
        Spacer(modifier = Modifier.width(7.dp))
        Text(text = userModel.userName ?: "")
    }
}