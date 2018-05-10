package com.shijc.hellokotlin.unit04

/*枚举*/

enum class Color{
    RED,BLACK,BLUE,GREEN,WHITE
}


enum class Color2(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class Shape(value:Int){
    ovel(100),
    rectangle(200)
}

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}


fun main(args: Array<String>) {
    var color:Color=Color.BLUE

    println(Color.values())
    println(Color.valueOf("RED"))
    println(color.name)
    println(color.ordinal)

}