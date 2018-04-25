package com.shijc.hellokotlin.unit10

/*类型检查和类型转换*/
fun c10_4_temp1(){
    var obj:Any = 456
    var obj1 = 123
    var obj2 = "hello"

    if(obj is String){
        println("obj是字符串")
    }

    if (obj is Int){
        println("obj是Int类型")
    }

    if (obj!is Int){
        println("obj不是Int类型")
    }
}


fun c10_4_temp2(){
    var y:Any = "abcd"
    var x:Int = y as Int // abcd无法转换为数值，因此会抛出异常
}


fun c10_4_temp3(){
    var y:Any? = "abcd"
    var x:Int? = y as? Int // 转换错误，但不会抛出异常，x的值是null
    println(x) // 输出null
}