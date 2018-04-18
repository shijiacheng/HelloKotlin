package com.shijc.hellokotlin.unit09

/*内联函数*/

fun processProduct(area:(name:String)->String):String{
    return area("iphone")
}

inline fun processProduct2(area:(name:String)->String):String{
    return area("iphone")
}

inline fun processProduct3(area1:(name:String)->String,noinline area2:(name:String)->String):String{
    return area1("iphone") +" "+ area2("埃菲尔铁塔")
}

fun main(args: Array<String>) {
//    println(processProduct2 { name -> "${name} 美国" })
    println(processProduct3 ({ name -> "${name} 美国" },{ name -> "${name} 法国" }))
}