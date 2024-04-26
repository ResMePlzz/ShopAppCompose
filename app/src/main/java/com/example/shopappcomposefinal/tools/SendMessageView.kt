package com.example.shopappcomposefinal.tools

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shopappcomposefinal.domain.model.MessageModel
import com.example.shopappcomposefinal.presentation.viewmodels.ChatScreenViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxScope.SendMessageView(chatScreenViewModel: ChatScreenViewModel) {

    val textState = rememberSaveable() {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = true) {
        chatScreenViewModel.addListener()
    }



    Card(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(3.dp))
            OutlinedTextField(
                value = textState.value,
                onValueChange = { newText -> textState.value = newText })
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        chatScreenViewModel.addMessage(
                            messageModel = MessageModel(
                                message = textState.value,
                                userName = chatScreenViewModel.getCurrentUserName()
                            )
                        )
                        textState.value = ""
                    },

                )

        }
        Spacer(modifier = Modifier.height(63.dp))

    }


}