package com.example.myapplication
import java.util.Scanner
class MyAccount {
    enum class type{
        A,B,C,D,E,F
    }
    var name: String = "Kim"
    var accountBalance:Int = 0
    var creditRating = type.C
    var check = 0

    fun Deposite(d:Int)
    {
        var prevMoney:Int = accountBalance
        accountBalance += d
        if(accountBalance > 0 && prevMoney < 0) {
            println("Your account is unfrozen now.")
        }
    }

    fun Withdraw(w:Int)
    {
        accountBalance -= w
        if(creditRating == type.F || accountBalance < -1000) {
            println("Your account is now freezed")
            check = 1
        }

    }

    fun downGrade()
    {
        var prev:type = creditRating
        println("The total amount was reduced")
        if(accountBalance>=-1000 && accountBalance<0 && creditRating != type.F)
        {
            creditRating = type.values()[creditRating.ordinal+1]
            println("Your credit rating has been decreased from $prev to $creditRating")
        }

    }

    fun upGrade() {
        if (accountBalance >= 0) {
            var prev: type = creditRating
            creditRating = type.values()[creditRating.ordinal - 1]
            println("Your credit rating has been increased from $prev to $creditRating")
        }
    }
}

fun main()
{
    val reader = Scanner(System.`in`)
    var choice:Char
    choice = ' '
    var acc:MyAccount = MyAccount()


    while (choice != 'E') {
        println("---------Choose operation---------")
        println("|(I) Account information         |")
        println("|(D)  Deposit                    |")
        println("|(W) Withdrawal                  |")
        println("|(E) Exit                        |")
        choice = reader.next().single()
        if (choice == 'I')
        {
            println("The account information is written below: ")
            println("|Name:              ${acc.name}  |")
            println("|Account balance:   ${acc.accountBalance}  |")
            println("|Credit rating:     ${acc.creditRating}  |")
            println("------------------------------------------")
        }
        else if (choice == 'D') {
            println("Please enter the deposit amount.")
            var amount:Int = reader.nextInt()
            acc.Deposite(amount)
            acc.upGrade()
            println("$amount won has been deposited. Total amount is ${acc.accountBalance}")
        }
        else if (choice == 'W') {
            if(acc.check == 1)
                println("This operation is impossible for the freezed account.")
            else {
                println("Please enter the withdraw amount.")
                var amount: Int = reader.nextInt()
                acc.Withdraw(amount)
                acc.downGrade()
                println("$amount won has been withdrawn. Total amount is ${acc.accountBalance}")
            }
        }
    }
}


