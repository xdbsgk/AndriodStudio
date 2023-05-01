package com.example.myapplication
import java.util.*

fun main() {
    var num = 0;
    var pairList: MutableList<Int> = mutableListOf()

    val sc: Scanner = Scanner(System.`in`)
    num = sc.nextLine().toInt()

    for (i: Int in 0..num - 1 step (1)) {
        var temp = sc.nextLine().toInt()
        pairList.add(temp)
    }

    var cnt = 0
    for (i: Int in 0..num - 1 step (1)) {
        print("Pairs for " + pairList[i] + " : ")
        for(a: Int in 1..pairList[i] step (1)) {
            for(b: Int in 1..pairList[i] step (1)) {
                if (a + b == pairList[i] && a < b) {
                    if (cnt == 0) {
                        cnt++
                        print("(" + a + " " + b + ")")
                    } else {
                        print(", " + "(" + a + " " + b + ")")
                        cnt=0;
                    }
                }
            }
        }
        println()
    }
}