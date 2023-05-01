// [예제 2] 예외 처리
package com.example.lab_20220317
import java.lang.NumberFormatException

// 에러 메세지를 반환하는 클래스 선언
class ScoreInvalidException(message : String): Exception(message)
// score 를 인자로 받아 String grade 를 반환하는 함수 선언
fun gradeFunc(score: Int):String {
    if ( score>100 || score<0 ){
        throw ScoreInvalidException("0~100의 범위를 넘었습니다.")
    }
    // score 의 범위에 따라 해당 grade 를 return
    return when(score){
        in 90..100 -> "A"
        in 80..90 -> "B"
        in 70..80 -> "C"
        in 60..70 -> "D"
        else -> "F"
    }
}

fun main() {
    try{
        println("시험점수를 입력하세요.")
        val score = readLine()!!.toInt() // '||'는 NULL 값을 받지 않을 것이라고 미리 말해주는 표시
        val grade = gradeFunc(score)
        println("${score} : ${grade} 등급")
    } catch (e:NumberFormatException) {
        println("형 변환이 불가능합니다.") // readline 으로 읽은 값: String 형식, 숫자값 아닐 시 에러 반환
    } catch (e:ScoreInvalidException) {
        println(e.message) // gradeFun 함수 내 throw 한 에러(ScoreInvalidException) 받을 경우 실행
    } finally {
        println("프로그램 종료")
    }
}
