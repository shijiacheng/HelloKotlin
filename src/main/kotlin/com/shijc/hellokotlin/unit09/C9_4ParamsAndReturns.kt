package com.shijc.hellokotlin.unit09

/* 将一组值转换为List<T>对象 */
fun <T> asList(vararg ts:T):List<T>{
    var result=  ArrayList<T>()
    for (t in ts)
        result.add(t)
    return result
}

/* vararg之后的其他参数可以使用命名参数语法来传递参数值 */
fun <T> asList2(vararg ts:T,value1:Int,value2:String):List<T>{
    var result=  ArrayList<T>()
    for (t in ts)
        result.add(t)
    println("value1=${value1} value2=${value2}")
    return result
}

fun main(args:Array<String>){
    /*var list = asList(1,2,"a",4,5)
    println(list)

    var list2 = asList2(1,2,"a",value1 = 4,value2 = "5")
    println(list2)*/


    val a = arrayOf(1,2,3)
    var list = asList(-1,0,*a,4,5)
    println(list)

}