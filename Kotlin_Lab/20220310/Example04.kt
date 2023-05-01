package com.example.myapplication
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt() // 일 할 수 있는 날짜 (1 이상 15 이하의 자연수)

    var T = IntArray(N + 10) // 시간을 저장할 배열
    var P = IntArray(N + 10) // 각 날짜별 금액을 저장할 배열
    var dp = IntArray(N + 10) // 각 날짜별 최대 누적 금액을 저장할 배열

    var max = 0

    var possible = 0
    for(i:Int in 0..N-1 step(1))
    {
        val numbers = readLine().split(" ").map{ it.toInt() }
        T[i] = numbers[0]
        P[i] = numbers[1]
    }
    for(i: Int in 0..N-1 step(1)) {
        var g: Int = i
        if(T[g]<N-g) {
            possible = P[g]
            while (g + T[g] < N - 1) {
                g = g + T[g]
                possible += P[g]
            }
        }
        else possible = 0
        dp[i] = possible
    }
    for(elem in dp)
    {
        if (elem>max)
            max = elem
    }

    println(max)
    close()

}