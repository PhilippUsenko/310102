package main.models

abstract class Employee(
    val name: String, //неизм перем
    var money: Double = 0.0
) {

    fun receiveSalary(amount: Double) {
        money += amount
        println("$name получил: $amount. Баланс: $money")
    }

}