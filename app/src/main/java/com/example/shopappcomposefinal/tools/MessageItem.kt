package com.example.shopappcomposefinal.tools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.shopappcomposefinal.domain.model.MessageModel
import com.example.shopappcomposefinal.presentation.viewmodels.ChatScreenViewModel

@Composable
fun MessageItem(messageModel: MessageModel, chatScreenViewModel: ChatScreenViewModel) {


    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (messageModel.message == chatScreenViewModel.currentUser.userName)
            Arrangement.End
        else Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        Card(
            modifier = Modifier
        )
        {
            Row(modifier = Modifier) {
                Text(
                    text = messageModel.message,
                    fontSize = 20.sp,


                    )


            }
        }
    }
}