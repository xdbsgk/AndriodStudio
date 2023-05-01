package com.example.myapplication
import java.util.*

// 1. 클래스 정의
enum class Year{Freshman, Sophomore, Junior, Senior}
class Student(var year:Year, var name: String, var id: Int) {
    fun print_information(){
        println("YEAR: ${year}, NAME: ${name}, ID: ${id}")
    }
}
// 2. 객체 및 배열 선언
fun main() {

    var students: MutableList<Student> = mutableListOf()

    students.add(Student(Year.Freshman, "Kim", 202124437))
    students.add(Student(Year.Freshman, "Kim", 202124437))
    students.add(Student(Year.Sophomore, "Kim", 202024437))
    students.add(Student(Year.Junior, "Kim", 201924437))
    students.add(Student(Year.Senior, "Kim", 201824437))

// 3. 배열 필터링
    var freshman_students = students.filter { it.year == Year.Freshman }

    for(student in freshman_students) {
        student.print_information()
    }
}
