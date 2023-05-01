package com.example.myapplication
import java.util.*

class Calculator() {
    private var ress = emptyArray<Double>()
    private var res = 0.0
    private fun add(a: Double, b: Double) {
        res = a+b
        ress=ress.plus(res)
    }
    private fun subtract(a: Double, b: Double) {
        res = a-b
        ress=ress.plus(res)
    }
    private fun multiple(a: Double, b: Double) {
        res = a*b
        ress=ress.plus(res)
    }
    private fun division(a: Double, b: Double) {
        if(b==0.0) {
            println("ERROR: number can not be divided with zero.")
        }
        else
            res = a/b
            ress=ress.plus(res)
    }

    fun load() {
        for(i in ress)
            println(i)
    }

    fun cal(a: Double, b: Double, type: String) {
        when(type){
            "add" -> add(a,b)
            "subtract" -> subtract(a, b)
            "multiple" -> multiple(a, b)
            "division" -> division(a, b)
        }
    }

    fun print_calculated_number() {
        println(res)
    }
}
fun main() {
    var calculator = Calculator()
    calculator.cal(1.0, 2.0, "add")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "subtract")
    calculator.print_calculated_number()
    calculator.cal(1.0, 0.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "multiple")
    calculator.print_calculated_number()
    println("---------------------------")
    calculator.load()
}