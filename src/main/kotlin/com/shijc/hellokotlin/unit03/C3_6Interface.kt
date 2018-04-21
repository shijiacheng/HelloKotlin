package com.shijc.hellokotlin.unit03

/*接口*/
interface MyInterface{
    fun process()
    fun getName():String{
        return "Bill"
    }
}

class MyClass2 :MyInterface{
    override fun process() {
        println("process")
    }

    override fun getName(): String {
        return "Mike"
    }

}

fun main(args: Array<String>) {
    println(MyClass2().getName())
    MyClass2().process()
}