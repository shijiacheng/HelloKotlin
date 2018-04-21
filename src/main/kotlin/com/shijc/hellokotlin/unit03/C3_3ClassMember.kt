package com.shijc.hellokotlin.unit03

/*类成员*/
class Customer2{

    var name:String = "Bill"
    var value:Int = 20
    var flag:Boolean = true

    fun getDesc(){
        println("name=${name} value=${value} flag=${flag}")
    }
}

class Customer3{
    // 只读属性
    val name:String
        get() = "Bill"

    // 读写属性
    var v:Int = 20
    var value:Int
        get() = v
        set(value){
            println("value属性被设置")
            v = value
        }
}

class Customer4{
    val name:String
        get() = "Bill"

    // 读写属性
    var value:Int = 0
        get() = field
        set(value){
            println("value属性被设置")
            field = value
        }
}

class QACommunity2{
    fun printQAcommunity(url:String,schema:String="http"){
        println("${schema}://${url}")
    }
}

class Person2{
    fun process(value: Int,name:String="Bill",age:Int=30,salary:Float=4000F){
        println("value=${value} name=${name} age=${age} salary=${salary}")
    }
}

class Person3(name: String){
    private var mName:String = name
    fun getName():String{
        return mName
    }
}

class Persons{
    fun addPersons(vararg persons:Person3):List<Person3>{
        var result = ArrayList<Person3>()
        for(person in persons){
            result.add(person)
        }
        return result
    }
}

/*函数单行表达式*/
class Person4(name: String){
    private var mName:String = name
    fun getName():String{
        return mName
    }

    //函数单行表达式
    fun getName1():String=mName
    // 函数单行表达式，省略返回值类型
    fun getName2() = mName
}

fun addPerson(name: String){
    //process函数作用域就是addPerson的函数体
    fun process(age: Int){
        println("age=${age}")
    }
    process(20)
    println("name=${name}")
}

/*嵌套类*/
class Outer{
    private val bar:Int = 1
    //嵌套类
    class Nested{
        fun foo() = 2
    }
}

class Outer2{
    private val bar:Int = 1
    inner class Inner{
        fun foo() = bar
    }
}

fun main(args: Array<String>) {
    /*Customer2().getDesc()*/

    /*var customer4 = Customer4()
    customer4.value = 40
    println(customer4.value)*/

    /*QACommunity2().printQAcommunity("shijiacheng.studio")*/

    /*Person2().process(30,"Bill",30,12000F)
    Person2().process(30,salary = 15000F)*/

    /*var persons = Persons().addPersons(Person3("Bill"), Person3("Jill"),Person3("Mike"))
    for (person in persons){
        println(person.getName())
    }*/

    val demo = Outer.Nested().foo()
    val demo2 = Outer2().Inner().foo()

}