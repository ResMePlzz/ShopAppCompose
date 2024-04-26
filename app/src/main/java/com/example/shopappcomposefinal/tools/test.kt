package com.example.shopappcomposefinal.tools

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


val data = flowOf(2, 4, 6)

val list = List<Int>(1000) {
    it
}

fun myFlow(): Flow<Int> = flow {
    list.forEach {
        delay(500)
        emit(it)
    }


}


suspend fun startFlow() {
    myFlow().collect {

    }
}


val myFun: (Flow<Int>, (Flow<String>) -> Unit) -> Unit = {
    flow, function->
    function(flow.map { it.toString() })
}

suspend fun eee(){
    myFun(myFlow()){
        CoroutineScope(Dispatchers.Default).launch {
            it.conflate().collect{
            }
        }

    }
}
