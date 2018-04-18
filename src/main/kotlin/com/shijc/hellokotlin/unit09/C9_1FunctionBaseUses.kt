package com.shijc.hellokotlin.unit09

// 函数的标准定义
fun double(x:Int):Int{
    return 2*x
}

fun main(args:Array<String>){
    // 调用函数
    double(3)
    println(double(4))
}