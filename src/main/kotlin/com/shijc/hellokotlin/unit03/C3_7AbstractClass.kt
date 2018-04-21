package com.shijc.hellokotlin.unit03

/*抽象类*/
open class Base{
    open fun f(){}
}

abstract class Derived:Base(){
    override abstract fun f()
}