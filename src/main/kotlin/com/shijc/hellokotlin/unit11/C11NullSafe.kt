package com.shijc.hellokotlin.unit11


/*null值安全性*/

fun main(args: Array<String>) {
    //var s:String = null //编译错误，a不可为null
    var b:String = "abc"
//    b = null //编译错误，b不可为null

    var c:String?="abc"
    c = null
    println(c?.length) //输出null
}