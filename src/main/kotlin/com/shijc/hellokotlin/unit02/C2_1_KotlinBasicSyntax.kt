package com.shijc.hellokotlin.unit02

/**
 * Kotlin的基本语法
 * Created by shijiacheng on 2018/3/18.
 */


/* 定义变量*/
var n: Int = 30
val m:Int = 10
var k = 100


/* 定义函数*/

fun add(m:Int,n:Int):Int{
    return m+n
}

fun progress(m:Int):Unit{
    println(m)
}

fun progress2(m:Int){
    println(m)
}


/*注释*/

// 这是单行注释

/*
    hello
        /*world*/
*/