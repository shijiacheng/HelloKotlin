package com.shijc.hellokotlin.unit03

/*构造器*/

/*class Person constructor(firstName:String){

}*/

class Person(firstName: String) {
    var name = firstName

    init {
        println(firstName)
    }
}


class QACommunity(var url: String) {
    //主构造器实现
    init {
        println(url)
    }

    // 第二构造器（通过this直接调用了主构造器）
    constructor(value: Int) : this("shijiacheng.studio") {
        println(value)
    }

    // 第二构造器（通过this直接调用了主构造器）
    constructor(desc: String, url: String) : this("(" + url + ")") {
        println(desc + ":" + url)
    }

    // 第二构造器（通过this调用了第二构造器，间接的调用了主构造器）
    constructor() : this(20) {
        println("<http://shijiacheng.studio>")
    }
}


/*单例模式*/
class Singleton private constructor() {
    public var value: Singleton? = null

    private object mHolder {
        val INSTANCE = Singleton()
    }

    companion object Factory {
        fun getInstance(): Singleton {
            return mHolder.INSTANCE
        }
    }

}

class Customer(var customerName:String = "Bill",var value: Float = 20.4F){

}

fun main(args: Array<String>) {
    /*println("*****第1个*****")
    QACommunity("http://shijiacheng.studio")
    println("*****第2个*****")
    QACommunity(20)
    println("*****第3个*****")
    QACommunity("我的博客", "http://shijiacheng.studio")
    println("*****第4个*****")
    QACommunity()*/

    var obj1 = Singleton.getInstance()
    var obj2 = Singleton.getInstance()

    println(obj1)
    println(obj2)
}
