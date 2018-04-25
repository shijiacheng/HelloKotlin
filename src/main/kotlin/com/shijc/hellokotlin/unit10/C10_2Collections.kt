package com.shijc.hellokotlin.unit10

import kotlin.collections.List

/*集合*/

//List接口
public interface List<out E>:Collection<E>{

}

//Set接口
public interface Set<out E>:Collection<E>{

}

//Map接口
public interface Map<K,out V>{

}

fun main(args: Array<String>) {

    // 创建可读写的列表对象
    val numbers:MutableList<Int> = mutableListOf(1,2,3)
    // 将读写列表变成字段列表
    val readOnlyView:List<Int> = numbers
    // 输出[1,2,3]
    println(numbers)
    //向numbers添加一个新元素
    numbers.add(4)
    // 输出[1,2,3,4]
    println(readOnlyView)
    //readOnlyView.clear()//编译出错，没有clear函数


    var mutableList:MutableList<String> = mutableListOf()
    var list:List<String> = mutableList.toList()
}
