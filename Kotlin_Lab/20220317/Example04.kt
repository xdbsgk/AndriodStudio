// [예제 4]소문자에서 대문자로 변환하는 함수 만들기
package com.example.lab_20220317

import androidx.core.util.lruCache

// 소문자를 대문자로 변환하는 change 함수
fun change(character: String) : String{
    var isLower : Boolean = true
    var errorRes = ""
    for (i: Int in 0..character.length-1 step(1)) {
        if (96 < character[i].toInt() && character[i].toInt() < 123) continue
        else {
            errorRes += character[i]
            isLower = false
        }
    }
    if (isLower) return character.toUpperCase()
    return "error with = ${errorRes}"
}
fun main() {

    var a = "abcd"
    println(change(a))

    var b = "EfgH"
    println(change(b))

    var c = "!@%$"
    println(change(c))
}