package com.shijc.hellokotlin.unit10

/*this表达式*/
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