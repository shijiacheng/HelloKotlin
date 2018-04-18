# 第9章 函数
## 9.1函数基本用法

```
// 函数的标准定义
fun double(x:Int):Int{
    return 2*x
}

fun main(args:Array<String>){
    // 调用函数
    double(3)
    println(double(4))
}
```

## 9.2使用中辍标记法调用函数

中辍表达式：指将函数名称放到两个操作数中间。这两个操作数，左侧是包含函数的对象或值，右侧是函数的参数值。

满足中辍标记法调用的函数满足的条件：
- 成员函数或者扩展函数
- 只有一个参数
- 使用infix关键字声明函数

例子：字符串除法，就是去除分子字符中包含的所有分母字符串
```
/*字符串除法*/
infix fun String.div(str:String):String{
    // 将当前字符串中的所有str替换成""
    return this.replace(str,"")
}
```


一般方式调用:
```
fun main(args:Array<String>){
    /*一般方式调用*/
    var str = "hello world"
    println(str.div("l"))
}
```
运行结果：
```$xslt
heo word
```

使用中辍表达式调用:
```$xslt
fun main(args:Array<String>){
    var str = "hello world"

    /*使用中辍表达式调用*/
    println(str div "l")
}
```

运行结果：
```$xslt
heo word
```

中辍表达式可以连续使用:
```$xslt
fun main(args:Array<String>){
    var str = "hello world"

    /* 中辍表达式可以连续使用*/
    println(str div "l" div "o")
}
```

运行结果：
```$xslt
he wrd
```

## 9.3单表达式函数

如果一个函数的函数体只要一条语句，而且是return语句，那么可以省略函数体的大括号，以及return关键字。return后面的表达式可以直接写在函数声明的后面，用等号与函数声明分割。
```$xslt
fun double1(x:Int):Int = x*2
```

如果Kotlin编译器能够推断出等号右侧的表达式类型，那么可以省略函数的返回值类型。
```$xslt
fun double2(x:Int) = x*2
```

## 9.4函数参数和返回值

可变参数：可以有任意多个参数

一个函数的一个参数（一般是最后一个参数）标记为vararg，这样可以作为可变参数处理。在函数内部，会按照数组来处理这些参数值。

asList功能是将一组值转换为List<T>对象，并返回改对象：
```
fun <T> asList(vararg ts:T):List<T>{
    var result=  ArrayList<T>()
    for (t in ts)
        result.add(t)
    return result
}
```
调用asList函数：
```
fun main(args:Array<String>){
    var list = asList(1,2,"a",4,5)
    println(list)
}
```

运行结果：
```
[1, 2, a, 4, 5]
```

只有一个参数可以标记vararg，如果vararg参数不是函数的最后一个参数，那么对于vararg参数之后的其他参数可以使用命名参数来传递参数值。

例子：下面的asList2有3个参数，第1个是可变参数，后面两个value1和value2，由于最后一个参数不是可变参数，因此传递value1和value2参数的时候后需要使用命名参数。

```
fun <T> asList2(vararg ts:T,value1:Int,value2:String):List<T>{
    var result=  ArrayList<T>()
    for (t in ts)
        result.add(t)
    println("value1=${value1} value2=${value2}")
    return result
}
```

调用asList2函数：
```
fun main(args:Array<String>){
    var list2 = asList2(1,2,"a",value1 = 4,value2 = "5")
    println(list2)
}
```

运行结果：
```
value1=4 value2=5
[1, 2, a]
```

如果我们已经有了一个数组，将数组的内容传递给asList函数，可以使用展开操作符，在数组之前加*

```
fun main(args:Array<String>){
    val a = arrayOf(1,2,3)
    var list = asList(-1,0,*a,4,5)
    println(list)

}
```

运行结果：
```
[-1, 0, 1, 2, 3, 4, 5]
```