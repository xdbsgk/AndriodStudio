// [예제 1] 변형 클래스
package com.example.lab_20220317

// 슈퍼클래스 선언
open class Beverage() {
    // 슈퍼클래스 안 drink 메소드 선언
    open fun drink(money:Int):Int {
        println("슈퍼클래스와 drink함수")
        return money
    }
}

// 세금과 세금계산 함수를 고차함수로 받으며, Beverage 클래스의 자식 클래스인 Cola 클래스 생성
class Cola(taxRate: Double, operation: (Double) -> Double) : Beverage() {
    var price = 600 // 콜라의 가격
    var tax = operation(taxRate) // 외부에서 정의된 고차함수를 사용하여 계산된 tax
    // drink 메소드 오버라이딩하여 재정의
    override fun drink(money: Int): Int {
        println("콜라를 마십니다.")
        return money - this.price -this.tax.toInt()
    }
}

// cola 클래스의 외부에서 메소드를 오버로딩하여 reset_cost 함수 정의
fun Cola.reset_cost(cost: Int) {
    price = cost
}

fun main() {
    // 매개변수 고차함수 정의
    var sub1 = Cola(10.0){taxRate->
        33.0*(taxRate/100.0)
    }
    println("잔돈:  ${sub1.drink(2000)}")

    sub1.reset_cost(300) // 콜라 값을 600 -> 300으로 변경.
    println("잔돈: ${sub1.drink(2000)}")
}