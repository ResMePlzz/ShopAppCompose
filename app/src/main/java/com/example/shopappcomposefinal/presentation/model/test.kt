package com.example.shopappcomposefinal.presentation.model

import android.util.Log


class Test() {


    inner class Class1()


    class Class2()

    val array: ArrayList<String> = ArrayList<String>()


    val list = listOf("sm" to 1, "sb" to 2, "so" to 3, "sr" to 4).filter { it.first != "xx" }


    val map = setOf<String>()

    val number = (1..100).toList().map { it.toString() }

    val a: String.() -> Unit = {

    }


    val z: (() -> Int) -> Unit = { onSuccess ->
        onSuccess()


    }


    //проинализировать все типы данных

    val fhjhf: Int = 1

    val fkjdrij: Char = 'e'

    val iirir: List<String> = listOf("fjdk")


    val y: (Int, Int) -> Unit = { a, b ->
        a + b
    }


    val myFun: (() -> Int) -> String = {
        it().toString()
    }




}

class Street():Home(){
    override fun clean() {
        TODO("Not yet implemented")
    }

}

//создать интерфейс у которого есть поля с инициализацией по умолчанию

sealed class Car(){
    class BMW
    class Audi
    class Mersedes
}


enum class Wether{
    KKK,OOO,HHH
}

val yu = Car.Mersedes()

val rir = Wether.HHH

abstract class Home{

   abstract fun clean()
}

interface Move