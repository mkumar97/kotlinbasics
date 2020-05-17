package com.example.helloworld

import kotlin.math.floor

fun main(){
    val stringList: List<String> = listOf("Conan", "Shinichi", "Ran", "Bourbon", "Akai")
    val mixedTypeList: List<Any> = listOf("Edogawa", 1000, "Kudo", 999.45)

    for(value in mixedTypeList){
        if (value is Int){
            println("Integer : $value")
        }
        else if (value is String){
            println("String : $value of length : ${value.length}")
        }
        else if (value is Double){
            println("Double : $value, with floor value ${floor(value)}")
        }
        else {
            println("Unknown Data Type")
        }
    }

    // Alternatively using When

    for (value in mixedTypeList){
        when(value){
            is Int -> println("Integer : $value")
            is String -> println("String : $value")
            is Double -> println("Double : $value")
            else -> println("Unknown Type")
        }
    }

    // Smart Cast - Explicit (safe) casting using the as? keyword
    val obj1: Any = 1337
    val str1: String? = obj1 as? String
    println(str1)

}
