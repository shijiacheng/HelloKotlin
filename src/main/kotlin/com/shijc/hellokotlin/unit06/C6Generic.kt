package com.shijc.hellokotlin.unit06

/*泛型*/

class Box<T>(t: T) {
    var value = t
}

fun <T> boxIn(value: T) = Box(value)

// 以下都是合法语句
val box4 = boxIn<Int>(1)
val box5 = boxIn(1)     // 编译器会进行类型推断


fun <T> doPrintln(content: T) {

    when (content) {
        is Int -> println("整型数字为 $content")
        is String -> println("字符串转换为大写：${content.toUpperCase()}")
        else -> println("T 不是整型，也不是字符串")
    }
}

/******************************************/

// 定义一个支持协变的类
class Runoob<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

// 定义一个支持逆变的类
class Runoob2<in A>(a: A) {
    fun foo(a: A) {
    }
}

fun main(args: Array<String>) {
    val box: Box<Int> = Box<Int>(1)
// 或者
    val box2 = Box(1) // 编译器会进行类型推断，1 类型 Int，所以编译器知道我们说的是 Box<Int>。


    var boxInt = Box<Int>(10)
    var boxString = Box<String>("Shijiacheng")

    println(boxInt.value)
    println(boxString.value)

    val age = 23
    val name = "runoob"
    val bool = true

    doPrintln(age)    // 整型
    doPrintln(name)   // 字符串
    doPrintln(bool)   // 布尔型


    var strCo: Runoob<String> = Runoob("a")
    var anyCo: Runoob<Any> = Runoob<Any>("b")
    anyCo = strCo
    println(anyCo.foo())   // 输出 a



    var strDCo = Runoob2("a")
    var anyDCo = Runoob2<Any>("b")
    strDCo = anyDCo
}

