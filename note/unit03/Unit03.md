# 第3章 类和接口

## 3.1类的声明

和Java一样，类的声明使用class关键字，如果声明一个空类，Kotlin和Java没有任何区别。

```
class MyClass{

}
```

## 3.2构造器

类允许定义一个主构造器和若干个第二构造器。

### 主构造器


主构造器是类头的一部分，紧跟在类名后面，构造器参数是可选的。

```
class Person constructor(firstName:String){

}
```

如果主构造器没有任何注释和修饰器，constructor关键字可省略
```
class Person (firstName:String){

}
```

主构造器需要在init块中进行初始化，在init块中可以直接使用主构造器的参数。

```
class Person (firstName:String){
    init {
        println(firstName)
    }
}
```

主构造器的参数不仅可以用在init块中，还可以用于对类属性进行初始化。

```
class Person (firstName:String){
    var name = firstName
    init {
        println(firstName)
    }
}
```
注意：即使在构造器内部使用var声明变量，修改参数变量值后，并不会把修改的值传到对象外部。

### 第二构造器

Kotlin可以声明若干个第二构造器。第二构造器需要在类中声明，前面必须要加constructor关键字。

如果类中声明了主构造器，那么所有的第二构造器都需要在声明后面调用主构造器，或者通过另外一个第二构造器间接地调用主构造器。

```
class QACommunity(var url:String){
    //主构造器实现
    init {
        println(url)
    }

    // 第二构造器（通过this直接调用了主构造器）
    constructor(value:Int):this("shijiacheng.studio"){
        println(value)
    }

    // 第二构造器（通过this直接调用了主构造器）
    constructor(desc:String,url: String):this("("+url+")"){
        println(desc+":"+url)
    }

    // 第二构造器（通过this调用了第二构造器，间接的调用了主构造器）
    constructor():this(20){
        println("<http://shijiacheng.studio>")
    }
}
```

调用QACommunity类的每个构造器：

```
fun main(args: Array<String>) {
    println("*****第1个*****")
    QACommunity("http://shijiacheng.studio")
    println("*****第2个*****")
    QACommunity(20)
    println("*****第3个*****")
    QACommunity("我的博客","http://shijiacheng.studio")
    println("*****第4个*****")
    QACommunity()
}
```

运行结果：

```
*****第1个*****
http://shijiacheng.studio
*****第2个*****
shijiacheng.studio
20
*****第3个*****
(http://shijiacheng.studio)
我的博客:http://shijiacheng.studio
*****第4个*****
shijiacheng.studio
20
<http://shijiacheng.studio>
```



