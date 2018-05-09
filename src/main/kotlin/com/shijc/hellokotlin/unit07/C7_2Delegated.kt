package com.shijc.hellokotlin.unit07

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*委托*/

// 创建接口
interface Base {
    fun print()
}

// 实现此接口的被委托的类
class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

// 通过关键字 by 建立委托类
class Derived(b: Base) : Base by b


//--------------------------------------------------


// 定义包含属性委托的类
class Example {
    var p: String by Delegate()
}

// 委托的类
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}



//-----------------------------
val lazyValue: String by lazy {
    println("computed!")     // 第一次调用输出，第二次调用不执行
    "Hello"
}




//---------------------------------------------

class User {
    var name: String by Delegates.observable("初始值") {
        prop, old, new ->
        println("旧值：$old -> 新值：$new")
    }
}




class Site2(val map: Map<String, Any?>) {
    val name: String by map
    val url: String  by map
}



class Site3(val map: MutableMap<String, Any?>) {
    val name: String by map
    val url: String by map
}





fun main(args: Array<String>) {
    val b = BaseImpl(10)
    Derived(b).print() // 输出 10



    val e = Example()
    println(e.p)     // 访问该属性，调用 getValue() 函数
    e.p = "Shijiacheng"   // 调用 setValue() 函数
    println(e.p)



    println(lazyValue)   // 第一次执行，执行两次输出表达式
    println(lazyValue)   // 第二次执行，只输出返回值




    val user = User()
    user.name = "第一次赋值"
    user.name = "第二次赋值"





    // 构造函数接受一个映射参数
    val site = Site2(mapOf(
            "name" to "石嘉成的博客",
            "url"  to "www.shijiacheng.studio"
    ))

    // 读取映射值
    println(site.name)
    println(site.url)




    var map:MutableMap<String, Any?> = mutableMapOf(
            "name" to "石嘉成的博客",
            "url" to "www.shijiacheng.studio"
    )

    val site3 = Site3(map)

    println(site3.name)
    println(site3.url)

    println("--------------")
    map.put("name", "Google")
    map.put("url", "www.google.com")

    println(site3.name)
    println(site3.url)
}