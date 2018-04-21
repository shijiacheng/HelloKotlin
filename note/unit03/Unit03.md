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

注意：在主构造器参数中可以使用可以使用var和val，但在第二构造器参数中不能使用var和val。这就意味着第二构造器的参数都是只读的，不能在构造器内部改变参数的值。

### Kotlin中的Singleton模式

```
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
```

执行下面代码，访问Singleton类：

```
fun main(args: Array<String>) {
    var obj1 = Singleton.getInstance()
    var obj2 = Singleton.getInstance()

    println(obj1)
    println(obj2)
}
```

运行结果：

```
com.shijc.hellokotlin.unit03.Singleton@355da254
com.shijc.hellokotlin.unit03.Singleton@355da254
```

执行这段代码后，会输出如下内容，我们会发现。obj1和obj2的输出结果完全一样。这就证明了obj1和obj2是完全一样的。



### Kotlin函数中的默认参数

Kotlin函数支持默认参数，例子：

```
class Customer(var customerName:String = "Bill",var value: Float = 20.4F){

}
```

如果创建Customer的实例，可以直接使用Customer()。customerName和value的参数值就会使用Bill和20.4。



### 创建类的实例

在Kotlin中创建类的实例不需要使用new关键字。因此，调用函数和创建类的实例在语法上没有区别。只能通过上下文来区分。



## 3.3类成员

### 属性的基本用法

```
var/val <propertyName>[:<propertyType>][=<property_initializer>]
	[<getter>]
	[<setter>]
```

在属性语法中，只有var/val和propertyName(属性名)是必须的，其他都是可选的。如果要引用属性，就行引用变量一样。

```
class Customer2{

    var name:String = "Bill"
    var value:Int = 20
    var flag:Boolean = true

    fun getDesc(){
        println("name=${name} value=${value} flag=${flag}")
    }
}
```

### 属性的getter和setter形式

如果属性是只读的，需要将属性声明为val，并只添加一个getter形式，如果属性是读写的，需要使用var是声明属性，并添加getter和vsetter形式。如果getter和setter中只有一行实现代码。直接用=分割getter和代码即可。如果包含多行代码需要使用{……}处理。

```
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
```

### 保存属性值的字段

在属性的getter和setter中，可以将field当做成员变量使用，也就是通过field读写属性值。

```
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
```

修改Customer4的value值：

```
fun main(args: Array<String>) {
    var customer4 = Customer4()
    customer4.value = 40
    println(customer4.value)
}
```

运行结果：

```
value属性被设置
40
```



### 函数

函数既可以在类外部定义，也可以在类内部定义。如果是前者是全局函数，如果是后者是类成员函数。

函数也支持默认参数值。要注意的是，带默认值的参数必须是最后几个参数，也就是说，如果某个参数带默认值。那么该参数后面的所有参数都必须有默认值。

```
class QACommunity2{
    fun printQAcommunity(url:String,schema:String="http"){
        println("${schema}://${url}")
    }
}
```

执行代码：

```
fun main(args: Array<String>) {
    QACommunity2().printQAcommunity("shijiacheng.studio")
}
```

运行结果：

```
http://shijiacheng.studio
```

如果我们想为下面的函数按顺序传入参数值，很简单

```
class Person2{
    fun process(value: Int,name:String="Bill",age:Int=30,salary:Float=4000F){
        println("value=${value} name=${name} age=${age} salary=${salary}")
    }
}
```

```
fun main(args: Array<String>) {
    Person2().process(30,"Bill",30,12000F)
}
```

如果我们只想修改最后 一个参数的值，安装之前的思路必须每个参数的值都传一遍，很麻烦。为了解决这个问题，Kotlin允许使用命名参数传递参数值。例如：

```
fun main(args: Array<String>) {
    Person2().process(30,salary = 15000F)
}frev
```

如果传入参数的参数个数不固定，就要使用可变参数了，可变参数用vararg关键字声明：

```
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
```

调用addPersons方法：

```
fun main(args: Array<String>) {
    var persons = Persons().addPersons(Person3("Bill"), Person3("Jill"),Person3("Mike"))
    for (person in persons){
        println(person.getName())
    }
}
```



函数单行表达式：如果Kotlin函数体只有一行代码，可以直接在函数声明后面加等号=，后面直接跟代码，这种表达方式可以省略函数返回值类型。

```
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
```



本地函数：在函数体内定义函数，作用域就是包含本地函数的函数体

```
fun addPerson(name: String){
    //process函数作用域就是addPerson的函数体
    fun process(age: Int){
        println("age=${age}")
    }
    process(20)
    println("name=${name}")
}
```



### 嵌套类

嵌套类就是类中定义的类。

```
class Outer{
    private val bar:Int = 1
    //嵌套类
    class Nested{
        fun foo() = 2
    }
}
```

调用foo方法：

```
fun main(args: Array<String>) {
    val demo = Outer.Nested().foo()
}
```

嵌套类还可以使用inner关键字声明，这样可以通过外部类的实例引用嵌套类

```
class Outer2{
    private val bar:Int = 1
    inner class Inner{
        fun foo() = bar
    }
}
```



## 3.4修饰符（Modifiers）

Kotlin中有private、protected、internal、public 4个修饰符。

- private：仅仅在类的内部可以访问
- protected：类似private，但在子类中也可以访问
- internal：在任何模块内部类都可以访问
- public：任何类都可以访问

如果不指定任何修饰符，默认是public。

```
open class Outer3{//open表明Outer2是可继承的
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 // 默认是public

    protected class Nested{
        public val e:Int = 5
    }

}
```

```
class SubClass:Outer3(){
    //无法访问父类的a常量
    //可以访问b、c、d
    // Nested类和e变量可以访问

    override val b =5 // 重写父类的常量b
}
```



## 3.5类的继承

### 类如何继承

Kotlin类的继承需要使用冒号（:）,冒号后需要调用父类的构造器，与Java一样，都是单继承的。要注意的是，Kotlin默认时class是final的，也就是说，默认时class不允许继承，需要显式的使用open关键字允许继承class。

```
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
```



### 重写方法

如果要在子类中重写方法，就需要在父类相应的方法前面加open关键字，而且要在子类重写的方法前面加override关键字。

```
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
```

现在调用Child2l类的getName方法，实际上执行的是Child2自身的getName方法，而不是Parent2类的getName方法。

如果一个方法前加了override，那么这个方法就可以被重写了，例如Child2类的getName方法在子类中是可以被再次重写的。

```
class MyChild2:Child2(){
    //再次重写getName方法
    override fun getName(): String {
        return "["+super.getName()+"]"
    }
}
```

如果想阻止getName方法被子类重写，需要在override前面加final

```
class MyChild3:Child2(){
    //再次重写getName方法
    final override fun getName(): String {
        return "["+super.getName()+"]"
    }
}
```



### 重写属性

属性的重写方式与方法类似，被重写的属性必须使用open声明，子类中重写的属性必须使用overr声明。注意的是，val属性可以被重写为var属性，但反过来不可以。

```
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
```

运行结果：

```
Child3.name被写入
获取Child3.name属性值
John
```



## 3.6接口

接口使用interface关键字声明，一个类可以实现多个接口。实现的方法和类继承相似。而且接口中的属性和方法都是open的。

```
interface MyInterface{
    fun process()
    fun getName():String{
        return "Bill"
    }
}

class MyClass2 :MyInterface{
    override fun process() {
        println("process")
    }

    override fun getName(): String {
        return "Mike"
    }

}

fun main(args: Array<String>) {
    println(MyClass2().getName())
    MyClass2().process()
}
```

在Kotlin中，允许接口的方法包含默认的方法体。对于有方法体的接口方法。并不要求一定重写该方法。也就是说getName方法可以在MyClass2中不重写。



## 3.7抽象类

抽象类不能被实例化，需要使用abstract关键字声明，抽象类实现接口后，接口中没有函数体的函数可以不重写（override），接口中的这些方法就自动被继承到实现接口的抽象类中，称为抽象方法。

```
open class Base{
    open fun f(){}
}

abstract class Derived:Base(){
    override abstract fun f()
}
```

抽象方法不需要使用open声明，因为抽象类本身就是可继承的。