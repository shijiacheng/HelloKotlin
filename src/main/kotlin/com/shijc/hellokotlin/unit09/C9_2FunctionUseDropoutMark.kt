package com.shijc.hellokotlin.unit09

/*字符串除法*/
infix fun String.div(str:String):String{
    // 将当前字符串中的所有str替换成""
    return this.replace(str,"")
}



fun main(args:Array<String>){
    var str = "hello world"
    /*一般方式调用*/
    /*println(str.div("l"))

    *//*使用中辍表达式调用*//*
    println(str div "l")*/

    /* 中辍表达式可以连续使用*/
    println(str div "l" div "o")
}