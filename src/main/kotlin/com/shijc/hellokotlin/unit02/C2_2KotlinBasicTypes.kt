package com.shijc.hellokotlin.unit02

/**
 * 基础数据类型
 * Created by shijiacheng on 2018/3/18.
 */
/*数值类型*/
fun numberType(){

    var a :Int = 20
    var price:Double = 20.4
    var flag : Boolean= true
    var v1:Float = 19.2f
    var v2:Long = 100L
    var v3:Long = 100 //可以将int隐式转换为long类型
    var b:Byte = 10
    var c:Short = 15

    a = b.toInt() // Byte转换为Int类型
    a = c.toInt() // Short转换为Int类型


    //下划线作为数值的分隔符
    val creditNumber = 1_000_000_000

}

/*字符类型*/
fun charType(c:Char){
    //在kotlin中，字符不能直接看做是数字
    if (c=='a'){
        //编译可以通过
    }
}
//将字符转换为数值
fun decimalDigitValue(c:Char):Int{
    if (c !in '0'..'9'){
        throw IllegalArgumentException("out of range")
    }

    return c.toInt() - '0'.toInt()
}

/*布尔类型*/
fun boolenType(){
    var flag1 : Boolean = true;
    var flag2:Boolean = false;
    flag1 = false;

    if (flag1 && !flag2){
        println("flag1 && !flag2")
    }
    if (!flag1 || flag2){
        println("!flag1 || flag2")
    }

}

/*数组*/
fun arrayType(){
    // 使用arrayOf函数定义可以存储任意值的数组
    val arr1 = arrayOf(1,2,3,'a')
    println(arr1[3])
    arr1[2] = 'b'
    println(arr1[2])

    // 使用arrayOfNulls函数定义数组，可以指定数组大小
    var arr2 = arrayOfNulls<Int>(10)
    println(arr2.size)

    // 使用Array类的构造器定义数组，其中第二个参数是初始化每一个数组元素的值
    val arr3 = Array(10,{i -> (i*i).toString()})
    println(arr3[3])

    // 使用intArrayOf函数定义数组
    var arr4:IntArray = intArrayOf(1,3,5,7,9)
    println("arr4[2] = "+arr4[2])
}

/*字符串*/
fun stringType(){
    // 普通字符串
    var s1 = "hello\nworld"
    var s2:String = "你好\n世界"

    println(s1)
    println(s2)

    // 保留原始格式的字符串
    var s3 = """

111
        222

     333
           444
        """

    println(s3)
}

/*字符串模板*/
fun stringTempliate(){
    var s = "abc"
    var str = "${s}的长度是${s.length}"
    println(str)
}

fun main(args:Array<String>){
    /*var result = decimalDigitValue('3')
    println(result)*/

    /*boolenType()*/

    /*arrayType()*/

    /*stringType()*/

    stringTempliate()
}