package main.models

import kotlin.random.Random

class Programmer(name: String) : Employee(name) {

    fun writeCode(company: Company): Int{ //функция принимает объект класса Company
        println("$name пишет код...")
        if (company.getTasks() > 0) {
            val tasksCompleted = Random.nextInt(1, company.getTasks() + 1) //количество выполненных задач
            company.decreaseTasks(tasksCompleted) // Уменьшаем количество задач в компании на количество выполненных
            return tasksCompleted
        }
        println("Нет задач для выполнения")
        return 0

    }

    fun askForRaise(tasksCompleted: Int, tasksToComplete:Int): Double { //принимает два параметра (количество выполненных задач
        // и общее количество задач) и возвращает сумму повышения типа Double.
        val baseRaiseAmount = 100.0
        println("$name попросил повышение зарплаты на сумму: ${baseRaiseAmount * tasksCompleted} за выполнение $tasksCompleted задач.")
        if (tasksCompleted >= tasksToComplete/2){
            return tasksCompleted * baseRaiseAmount
        }
        return baseRaiseAmount
    }
}