package com.shijc.hellokotlin.unit2

/**
 * Kotlin控制流
 * Created by shijiacheng on 2018/3/18.
 */

/*条件语句*/
fun ifControl(){
    var a:Int = 20
    var b = 30
    var max:Int
    if (a<b){
        max = b
    }

    var min:Int

    if (a>b){
        min = b
    }else{
        min = a
    }
    println(min)

}

// 将if语句作为表达式使用
fun ifControl2(){
    var a = 20
    var b = 30
    var max = if (a>b) a else b
    println(max)

    var min = if (a<b){
        print("choose a=")
        a
    }else{
        print("choose b=")
        b
    }
    println(min)
}

/*when语句*/

// when作为语句使用
fun whenControl(){
    var x = 1
    when(x){
        1 -> {
            println("x==1")
            println("hello world")
        }

        2-> println("x==2")
        else->{
            println("x is neither 1 nor 2")
        }
    }
}

// when作为表达式使用
fun whenControl2(){
    var x = 1
    var m = when(x){
        1 -> {
            20
        }
        2 ->{
            30
        }
        else ->{
            40
        }
    }

    println(m)
}

// 多个分支执行相同的代码
fun whenControl3(){
    var x = 1
    when(x){
        1,2 -> {
            println("符合条件")
        }
        else ->{
            println("条件未知")
        }
    }
}

// 使用in关键字
fun whenControl4(){
    var x = 15
    when(x){
        in 1..20-> println("满足条件")
        !in 30..60-> println("hello world")
        else-> println("条件未知")
    }

}

// 分支条件是函数
fun getValue(x:Int):Int{
    return x*x
}
fun whenControl5(){
    var x = 4
    when(x){
        getValue(2)-> println("满足条件")
        getValue(3)-> println("不满足条件")
        else-> println("条件未知")
    }
}

fun main(args:Array<String>){
    /*ifControl()*/

    /*ifControl2()*/

    /*whenControl()*/

    /*whenControl2()*/

    /*whenControl3()*/

    /*whenControl4()*/

    whenControl5()
}