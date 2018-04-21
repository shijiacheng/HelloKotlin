package com.shijc.hellokotlin.unit03

/*类的继承*/

open class Parent {// 需要open声明Parent，才允许其他类继承
    protected var mName: String = "Bill"

    fun getName(): String {
        return mName
    }
}

class Child:Parent(){
    //Child类继承了Parent类，mName和getName在Child中都可以访问了

    fun printName(){
        println(mName)
    }
}

/*重写方法*/

open class Parent2 {// 需要open声明Parent，才允许其他类继承
    protected var mName: String = "Bill"

    open fun getName(): String {
        // 只有加open关键字，getname才可以被子类的方法重写
        return mName
    }
}

open class Child2:Parent2(){
    //Child类继承了Parent类，mName和getName在Child中都可以访问了

    fun printName(){
        println(getName())
    }

    // 重写父类的getname方法
    override fun getName(): String {
        return "<"+super.getName()+">"
    }
}

class MyChild2:Child2(){
    //再次重写getName方法
    override fun getName(): String {
        return "["+super.getName()+"]"
    }
}

class MyChild3:Child2(){
    //再次重写getName方法
    final override fun getName(): String {
        return "["+super.getName()+"]"
    }
}

/*重写属性*/
open class Parent3{
    open val name:String="Bill"
        get() {
            println("获取Parent.name属性值")
            return field
        }
}

open class Child3:Parent3(){
    override var name:String = "Mike"
        get() {
            println("获取Child3.name属性值")
            return field
        }
        set(value){
            field = value
            println("Child3.name被写入")
        }
}

fun main(args: Array<String>) {
    var child = Child3()
    child.name = "John"
    println(child.name)
}