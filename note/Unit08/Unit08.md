# 第8章 高阶函数与Lambda表达式

## 8.1 高阶函数

高阶函数是一种特殊的函数，它接受函数作为函数，或者返回一个函数。在下面的例子中，processProduct是一个高阶函数，该函数的第1个参数是一个对象（Product类型），第2个参数是一个函数类型。这个函数类型需要传递一个name参数（String类型），并返回一个String类型。processProduct函数会通过第2个参数area为产品添加产地。

```
interface Product{
    var area:String
    fun sell(name:String)
}

class MobilePhone:Product{

    override var area: String = ""

    override fun sell(name: String) {
        println("销售${name}")
    }

    override fun toString(): String {
        return area
    }

}

fun mobilePhoneArea(name: String):String{
    return "${name} 美国"
}

fun processProduct(product: Product,area:(name:String)->String):Product{
    //调用第二个参数指定的函数
    product.area = area("iphone")
    return product
}

fun main(args: Array<String>) {
    var product = MobilePhone()
    //将函数作为函数值传入高阶函数，需要在函数名前加两个冒号，作为标记
    processProduct(product,::mobilePhoneArea)
    println(product)
}
```

运行结果：

```
iphone 美国
```



## 8.2 Lambda表达式与匿名函数

Lambda表达式，或者称为匿名函数，是一种”函数字面值“，也就是一个没有声明的函数，但是可以作为表达式传递出去。

```
max(strings,{a,b->a.length < b.length})
```

函数max是一个高阶函数，也就是说，它接受一个函数值作为第二个参数。第二个参数是一个表达式，本身又是另一个函数，也就是说，它是一个函数字面量。作为函数等价于下面的代码：

```
fun compare(a:String,b:String):Boolean = a.length<b.length
```



### 函数类型

对于接受另一个函数作为自己参数的函数，我们必须针对这个参数指定一个函数类型。

```
fun <T> max(collection: Collection<T>,less:(T,T) -> Boolean):T?{
    var max:T? = null
    for (it in collection)
        if (max == null || less(max,it))
            max = it
    return max
}
```

参数less的类型是(T,T) -> Boolean，也就是说，它是一个函数，接受两个T类型参数，并且返回一个Boolean类型结果。


### Lambda表达式的语法

Lambda表达式的完整语法形式，也就是函数类型的字面值，如下：

```
val sum = {x:Int,y:Int -> x+y}
```

Lambda表达式包含在大括号之内，在完整语法形式中，参数声明在小括号内，参数类型的声明可选，函数体在->之后。如果Lambda表达式自动推断返回值类型不是Unit，那么在Lambda表达式函数体中，最后一条表达式的值会被当作整个Lambda表达式的返回值。

如果我们把所有可选内容去掉，那么剩余的部分如下：

```
val sum2 :(Int,Int) ->Int = {x,y->x+y}
```


很多情况下，Lambda表达式只有唯一一个参数，如果Kotlin能够自行判断出Lambda表达式的参数定义，那么它将允许我们省略唯一一个参数的定义（"->"也可以一同省略），并且会为我们隐含的定义这个参数，使用能够函数名为it，例如，8.1节调用processProduct函数的代码可以改成如下：

```
processProduct(product){
    "${it}美国"
}
```

如果使用带标签限定的return语句，那么可以在Lambda表达式内明确的返回一个结果值。否则，会隐含的返回Lambda表达式内最后一条表达式的值。

```
processProduct2(product){
    return "${it}美国"
}
```



### 匿名函数

```
fun main(args: Array<String>) {
    fun(x:Int,y:Int):Int = x+y
}
```

匿名函数省略了函数名，函数体可以是一个表达式，也可以是多条语句组成的代码段：

```
fun main(args: Array<String>) {
    fun(x:Int,y:Int):Int{
        return x+y
    }
}
```

参数和返回值类型的声明与通常的函数一样，但如果参数类型可以通过上下文推断得到，那么类型声明可以省略。

```
fun main(args: Array<String>) {
    ints.filter(fun(item) = item>0)
}
```



对于匿名函数，返回值类型的自动推断方式与通常的函数一样：如果函数体是一个表达式，那么返回值类型可以自动推断得到；如果函数体是多条语句组成的代码段，则返回值类型必须明确指出，否则认为是（Unit）

注意：匿名函数参数一定要在小括号内传递。允许将函数类型参数写在小括号之外的语法，仅对Lambda表达式有效。


### 闭包

Lambda表达式、匿名函数可以访问他/她的闭包，也就是定义在外层范围中的变量。与Java不同，闭包中捕获的变量是可以修改的。

```
fun main(args: Array<String>) {
    var sum = 0
    ints.filter{it>0}.forEach{
        sum+=it
    }  
    println(sum)
}
```

