package com.shijc.hellokotlin.unit09

/* 函数的范围 */

fun saveFile(){
    fun getFullName(fn:String):String{
        return "/user/${fn}"
    }

    var fileName = getFullName("test.txt")
    println("${fileName}已经保存成功")
}

fun saveFile2(){
    var fn = "text.txt"
    fun getFullName():String{
        return "/user/${fn}"
    }

    var fileName = getFullName()
    println("${fileName}已经保存成功")
}


class Sample(){
    //成员函数
    fun foo(){
        println("foo")
    }
}

fun main(args: Array<String>) {
    saveFile()
    saveFile2()

    Sample().foo()
}