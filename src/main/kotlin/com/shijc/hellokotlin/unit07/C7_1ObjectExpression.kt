package com.shijc.hellokotlin.unit07

/*对象表达式*/

class C {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
//        val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}


object Site {
    var url:String = ""
    val name: String = "石嘉成的博客"
}



fun main(args: Array<String>) {
    val site = object {
        var name: String = "石嘉成的博客"
        var url: String = "www.shijiacheng.studio"
    }
    println(site.name)
    println(site.url)



    var s1 =  Site
    var s2 = Site
    s1.url = "www.shijiacheng.studio"
    println(s1.url)
    println(s2.url)



    val b = BaseImpl(10)
    Derived(b).print() // 输出 10



    val e = Example()
    println(e.p)     // 访问该属性，调用 getValue() 函数
    e.p = "Shijiacheng"   // 调用 setValue() 函数
    println(e.p)
}