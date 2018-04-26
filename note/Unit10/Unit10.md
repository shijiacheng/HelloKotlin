# 第10章 其他Kotlin技术（1）

## 10.1数据解构

数据解构就是讲对象中的数据解析成相应的独立变量，也就是脱离原来的对象存在。

```
data class Person(var name:String,var age:Int,var salary:Float)
```

这行代码是一个Person数据类，该数据类有3个参数，下面的代码要将这3个参数对应的属性值赋给相应的3个变量。

```
fun main(args: Array<String>) {
    var person = Person("Bill",30,1200F)
    var(name,age,salary) = person
    println("name=${name} age=${age} salary=${salary}")
}
```

运行结果：

```
name=Bill age=30 salary=1200.0
```

如果想让一个函数返回多个值。并能解构这些值，也需要返回数据类对象。

```
fun deletePerson(id:Int):Person{
    println("已经成功删除指定Person")
    var person = Person("Bill",30,1200F)
    return person
}
```

调用deletePerson函数，并解构其返回值的代码如下：

```
var(name,age,salary) = deletePerson(20)
println("name=${name} age=${age} salary=${salary}")
```



有很多对象，可以保存一组值。例如Map。下面的代码创建MutableMap对象，并保存了两个key-value值对，然后通过for语句将其解构出来。

```
var map = mutableMapOf<Int,String>()
    map.put(10,"Bill")
    map.put(20,"Mike")

    for ((key,value) in map){
        println("key=${key} value=${value}")
    }
```

运行结果：

```
key=10 value=Bill
key=20 value=Mike
```

其中这些对象都是通过数据类实现的。例如，我们也可以自己来实现类似的功能。

```
data class MyArrayItem(var key:Int,var value:String,var comment:String)

fun valueArray():Collection<MyArrayItem>{
    var result = arrayListOf<MyArrayItem>(MyArrayItem(20,"A","Comment1"),
            MyArrayItem(30,"B","Comment2"),
            MyArrayItem(40,"C","Comment3"))
    return result
}
```

执行一下：

```
for ((key,value,comment) in valueArray()){
        println("key=${key} value=${value} comment=${comment}")
    }
```

运行结果：

```
key=20 value=A comment=Comment1
key=30 value=B comment=Comment2
key=40 value=C comment=Comment3
```





## 10.2集合

Kotlin标准库将集合分为可修改和不可修改的。不可修改的集合API包括List、Set、Map，可修改的集合的API包括MutableList、MutableSet、MutableMap等。这些API都是接口，而且他们都是Collection的子接口。

如果泛型用out声明，那么该泛型只能用于读操作。

下面是一些集合常用的方式：

```
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
    
}
```

下面是一些常用的创建集合对象的函数。

- listOf：用于创建List对象
- setOf：用于创建Set对象
- mapOf：用于创建Map对象
- mutableListOf：用于创建mutable对象
- mutableSetOf：用于创建mutableSetOf对象
- mutableMapOf：用于创建mutableMapOf对象

对于可读写的集合，可以通过toXxx函数将其转换为只读的版本，其中Xxx是List、Set和Map。

```
var mutableList:MutableList<String> = mutableListOf()
var list:List<String> = mutableList.toList()
```



## 10.3值范围

值范围表达式使用rangeTo函数实现，该函数的操作符形式是两个点（..），另外还有两个相关操作符in和!in。任何可比较大小的数据类型都可以定义值范围。

```
    var n = 20
    if (n in 1..100){
        println("满足要求")
    }

    if (n !in 30..80){
        println("符合条件")
    }
```

整数的值范围（IntRange、LongRange、CharRange）还有一种额外的功能，就是可以对这些值范围进行遍历。

```
    for (i in 1..10){
        println(i*i)
    }
```

执行这段代码会输出1到100内的10个数。



如果按照倒序输出，只需要使用标准库中的downTo函数即可。

```
    for (i in 10 downTo 1){
        println(i*i)
    }
```



如果要修改步长，就要使用step函数。

```
    for (i in 1..10 step 2){
        println(i*i)
    }

    for(i in 10 downTo 1 step 3){
        println(i*i)
    }
```



前面的代码中，使用的都是闭区间，1<=i<=10。如果要表示1<=i<10，需要使用until函数。

```
    for (i in 1 until 10){
        println(i)
    }
```





## 10.4类型检查和类型转换



### is与!is操作符

is操作符：在运行时检查一个对象与一个给定的类型是否一致。!is与之相反。

```
var obj:Any = 456
    var obj1 = 123
    var obj2 = "hello"

    if(obj is String){
        println("obj是字符串")
    }
    
    if (obj is Int){
        println("obj是Int类型")
    }
    
    if (obj!is Int){
        println("obj不是Int类型")
    }
```

如果is表达式满足条件，Kotlin编译器会自动转换is前面的对象到后面的数据类型，也就是说上面一个if语句中，obj已经是String类型了。

要注意的是，对象和is后面的类型要兼容，否则无法编译通过。



### 强制类型转换

如果类型强制转换，而且类型不兼容，类型转换操作符通常会抛出一个异常。因此，我们称之为不安全的，在Kotlin中，不安全的类型转换使用中缀操作符as。

```
var y:Any = "abcd"
var x:Int = y as Int // abcd无法转换为数值，因此会抛出异常
```

注意：null不能被转换为String，因为这个类型不是可为null的。我们需要在类型转换操作符的右侧使用可为null的类型。



```
var y:Any? = "abcd"
var x:Int? = y as? Int // 转换错误，但不会抛出异常，x的值是null
println(x) // 输出null
```



## 10.5this表达式

为了表示当前函数的接收者。可以使用this表达式。在类的成员函数中，this指向这个类的当前对象实例。在扩展函数中或者带接受者的函数字面值中，this代表调用函数时，在点号左侧传递的接收者参数。

如果this没有限定值，那么它指向包含当前代码的最内层范围，如果想要指向其他范围内的this，需要使用标签限定符。

为了访问更外层范围内的this，使用this@label，其中@label是一个标签，代表我们想要访问的this所属的范围。

```
class A{
    inner class B{
        fun Int.foo(){
            var a = this@A //指向A的this
            var b = this@B

            var c = this // 指向foo()函数的接收者，一个Int值
            var c1 = this@foo // 指向foo()函数的接收者，一个Int值

            val finLit = lambda@ fun String.(){
                val d = this // 指向funLit的接收者
            }

            val finLit2 = { s : String ->
                val d1 = this // 函数的接收者，因为包含当前代码的Lambda表达式没有接收者
            }
        }
    }
}
```



## 10.6相等判断

在Kotlin中有两种相等判断。

- 引用相等，也即是两个引用指向同一个对象，使用"==="(以及他的相反操作!==)
- 结构相等，使用equals函数判断,使用"=="(以及他的相反操作!=)