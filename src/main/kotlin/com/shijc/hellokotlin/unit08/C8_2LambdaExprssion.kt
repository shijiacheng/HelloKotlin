package com.shijc.hellokotlin.unit08

import kotlin.math.max

/*Lambda表达式*/

fun compare(a:String,b:String):Boolean = a.length<b.length

fun <T> max(collection: Collection<T>,less:(T,T) -> Boolean):T?{
    var max:T? = null
    for (it in collection)
        if (max == null || less(max,it))
            max = it
    return max
}



val sum = {x:Int,y:Int -> x+y}


val sum2 :(Int,Int) ->Int = {x,y->x+y}


//processProduct(product){
//    "${it}美国"
//}
//
//processProduct2(product){
//    return "${it}美国"
//}

fun main(args: Array<String>) {

    fun(x:Int,y:Int):Int = x+y


    fun(x:Int,y:Int):Int{
        return x+y
    }

//    ints.filter(fun(item) = item>0)
//
//    var sum = 0
//    ints.filter{it>0}.forEach{
//        sum+=it
//    }

    println(sum)

}