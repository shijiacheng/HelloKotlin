package com.shijc.hellokotlin.unit03

open class Outer3{//open表明Outer2是可继承的
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 // 默认是public

    protected class Nested{
        public val e:Int = 5
    }

}

class SubClass:Outer3(){
    //无法访问父类的a常量
    //可以访问b、c、d
    // Nested类和e变量可以访问

    override val b =5 // 重写父类的常量b
}