// [예제 3] 클래스 만들기 (맥주와 와인)
package com.example.lab_20220317

enum class BeerType{LIGHT_LAGER, LIGHT_HYBRID, BOCK, AMBER_HYBRID, FRUIT}
enum class WineType{WHITE, ROSE, RED, SPARKLING, DESSERT}
class Beer(var name: String, var beerType: BeerType, var cost: Int)
class Wine(var name: String, var wineType: WineType, var cost: Int)

// 맥주 이름과 맥주 타입, 가격을 출력하는 함수 작성
fun Beer.print(){ println("맥주 이름: ${name}, 맥주 타입: ${beerType}, 맥주 가격: ${cost}") }
// 맥주의 가격을 바꾸는 함수 작성
fun Beer.change_price(price: Int) { cost = price}
// 와인은 유로 가격으로 받는데, 유로에서 원화로 환산된 가격을 출력하는 함수 작성 (원화:유로=1350:1 비욜로 작성하기)
fun Wine.euro_to_won() {
    println("유로: ${cost} , 원화: ${cost*1350}")
}

fun main() {

    var beer1 = Beer("Hite", BeerType.FRUIT, 200)
    var beer2 = Beer("Cass", BeerType.LIGHT_HYBRID, 200)

    beer1.change_price(600)
    beer1.print()
    beer2.change_price(600)
    beer2.print()

    var wine1 = Wine("Cabernet", WineType.RED, 10)
    var wine2 = Wine("Chardonnay", WineType.WHITE, 12)

    wine1.euro_to_won()
}
