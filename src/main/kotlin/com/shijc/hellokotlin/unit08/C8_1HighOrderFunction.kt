package com.shijc.hellokotlin.unit08

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