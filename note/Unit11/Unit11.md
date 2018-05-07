# 第11章 其他Kotlin技术(2)

## 11.1null值安全性

在Kotlin中，类型系统明确区分可以指向null的引用和不可以指向null的引用。例如，一个通常的String变量不可以指向null。

```
var s:String = null //编译错误，a不可为null
var b:String = "abc"
b = null //编译错误，b不可为null
```

要允许null值，我们可以将变量声明可为null的字符串类型：String?。

第二个方案是使用安全调用操作符:?。

```
var b:String?="abc"
b = null
println(b?.length) //输出null
```

如果b不是null，这个表达式就会返回b.length，否则返回null。这个表达式本身的类型为Int?。

安全调用在链式调用的情况下非常有用，只要属性链中任何一个属性为null，整个表达式就会返回null。



### Elvis表达式

