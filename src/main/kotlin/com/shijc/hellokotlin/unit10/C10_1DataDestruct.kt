package com.shijc.hellokotlin.unit10

/*数据解构*/
data class Person(var name:String,var age:Int,var salary:Float)

fun deletePerson(id:Int):Person{
    println("已经成功删除指定Person")
    var person = Person("Bill",30,1200F)
    return person
}

fun destructMap(){
    var map = mutableMapOf<Int,String>()
    map.put(10,"Bill")
    map.put(20,"Mike")

    for ((key,value) in map){
        println("key=${key} value=${value}")
    }
}


data class MyArrayItem(var key:Int,var value:String,var comment:String)

fun valueArray():Collection<MyArrayItem>{
    var result = arrayListOf<MyArrayItem>(MyArrayItem(20,"A","Comment1"),
            MyArrayItem(30,"B","Comment2"),
            MyArrayItem(40,"C","Comment3"))
    return result
}

fun main(args: Array<String>) {
    /*var person = Person("Bill",30,1200F)
    var(name,age,salary) = person
    println("name=${name} age=${age} salary=${salary}")*/

    /*var(name,age,salary) = deletePerson(20)
    println("name=${name} age=${age} salary=${salary}")*/

    destructMap()

    for ((key,value,comment) in valueArray()){
        println("key=${key} value=${value} comment=${comment}")
    }
}