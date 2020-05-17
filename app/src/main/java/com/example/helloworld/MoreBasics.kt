package com.example.helloworld

import java.lang.NumberFormatException

open class Base(){
    var a = 1 // public by default
    private val b = 2 //private to Base class
    protected open val c = 3 // visible to base and Derived class
    internal val d = 4 //visible inside same module
    protected fun e(){} //visible to Base and Derived class
}

class Derived: Base(){
    // a, b, d, e() are visible
    // b is not visible

    override val c = 9 // c is protected by open so can be overridden
}

fun main(){

    // Exceptions
    fun toInt(str: String): Int{
        return try {
            Integer.parseInt(str)
        }
        catch (e: NumberFormatException){0}
    }
    println(toInt("10.9"))

    val base = Base()
    // base.a and base.d are visible
    // base.b, base.c, base.e() are not visible

    val derived = Derived()
    //derived.c is not visible

    var arrayList1 = ArrayList<String>()
    arrayList1.add("Detective Conan")
    arrayList1.add("One Piece")
    arrayList1.add("Dragon Ball Z")

    for (i in arrayList1){
        println(i)
    }

    val arrayList2: ArrayList<String> = ArrayList<String>(5)
    var list: MutableList<String> = mutableListOf<String>()

    list.add("One Piece")
    list.add("Detective Conan")
    list.add("Dragon Ball Z")
    arrayList2.addAll(list)

    val itr = arrayList2.iterator()
    while (itr.hasNext()){
        println(itr.next())
    }

    println(arrayList2.get(2))
    println(arrayList2.size)

    // Lambda expressions i.e anonymous functions
    val sum1: (Int, Int) -> Int = {a: Int, b: Int -> a+b}
    sum1(1000, 8972)

    val sum2 = {a: Int, b: Int -> a+b}
    println(sum2(2838, 9892))
}