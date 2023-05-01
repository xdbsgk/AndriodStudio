import java.lang.NullPointerException
import java.lang.NumberFormatException
import java.util.*

var sc = Scanner(System.`in`)
var price = getMenu()
var change = 0
var inputCoin = 0

// 잔돈 반환하기
fun getChange(){
    change = inputCoin - price
}

// 돈 넣기
fun getCoin() {
    println("Insert Coin")
    try {
        inputCoin = sc.nextLine().toInt()
        println("${inputCoin}원을 넣었습니다.")
        if (inputCoin < price) {
            println("현금이 부족합니다.")
        } else if (inputCoin == price){
            println("감사합니다.")
        } else {
            getChange()
            print("감사합니다. 잔돈반환: $change")
        }
    } catch (e: NumberFormatException) {
        println("돈을 넣지 않았습니다.\n다시 돈을 넣어주세요.")
        getCoin()
    } catch (e: NullPointerException) {
        println("돈을 넣지 않았습니다.\n다시 돈을 넣어주세요.")
        getCoin()
    }
}

// 메뉴 선택하고 반환하기
fun getMenu(): Int {
    // 자판기 메뉴 출력
    println("==================MENU==================")
    println("| (1) 참깨라면     - 1,000원              |")
    println("| (2) 햄버거      - 1,500원              |")
    println("| (3) 콜라        - 800원                |")
    println("| (4) 핫바        - 1,200원              |")
    println("| (5) 초코우유     - 1,500원              |")
    println("Choose menu: ")
    try {
        var choice = sc.nextLine().toInt()
        if (choice < 1 || choice > 5) {
            println("아무것도 선택하지 않았습니다.\n다시 선택해주세요.")
            return getMenu()
        } else {
            when (choice) {
                1 -> println("참깨라면이 선택되었습니다.")
                2 -> println("햄버거가 선택되었습니다.")
                3 -> println("콜라가 선택되었습니다.")
                4 -> println("핫바가 선택되었습니다.")
                5 -> println("초코우유가 선택되었습니다.")
            }
            return getPrice(choice)
        }
    } catch (e: NullPointerException) {
        println("아무것도 선택하지 않았습니다.\n다시 선택해주세요.")
        return getMenu()
    } catch (e: NumberFormatException) {
        println("아무것도 선택하지 않았습니다.\n다시 선택해주세요.")
        return getMenu()
    }
}

// 선택한 메뉴의 가격정보 가져오기
fun getPrice(choice : Int) : Int {
    return when(choice) {
        1 -> 1000
        2 -> 1500
        3 -> 800
        4 -> 1200
        5 -> 1500
        else -> 0
    }
}

fun main() {
    getCoin()
}