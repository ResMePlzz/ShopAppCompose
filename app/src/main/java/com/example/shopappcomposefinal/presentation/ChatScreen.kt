package com.example.shopappcomposefinal.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shopappcomposefinal.domain.model.MessageModel
import com.example.shopappcomposefinal.presentation.viewmodels.ChatScreenViewModel
import com.example.shopappcomposefinal.tools.BottomNavigation
import com.example.shopappcomposefinal.tools.MessageItem
import com.example.shopappcomposefinal.tools.SendMessageView
import com.example.shopappcomposefinal.ui.theme.Pink80


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navigator: NavHostController, chatScreenViewModel: ChatScreenViewModel) {

    chatScreenViewModel.addListener()

    val listMessages: MutableState<List<MessageModel>> = remember {
        mutableStateOf(listOf())
    }

    listMessages.value = chatScreenViewModel.readAllMessage.observeAsState(listOf()).value



    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { },
        bottomBar = {

        })
    { it ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding() + 63.dp,
                ),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listMessages.value) {
                    MessageItem(messageModel = it, chatScreenViewModel)
                }
            }
            SendMessageView(chatScreenViewModel = chatScreenViewModel)
        }


    }


}