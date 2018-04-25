package com.shijc.hellokotlin.unit10

/*值范围*/

fun temp1(){
    var n = 20
    if (n in 1..100){
        println("满足要求")
    }

    if (n !in 30..80){
        println("符合条件")
    }
}


fun temp2(){
    for (i in 1..10){
        println(i*i)
    }
}

fun temp3(){
    for (i in 10 downTo 1){
        println(i*i)
    }
}

fun temp4(){
    for (i in 1..10 step 2){
        println(i*i)
    }

    for(i in 10 downTo 1 step 3){
        println(i*i)
    }
}

fun temp5(){
    for (i in 1 until 10){
        println(i)
    }
}

