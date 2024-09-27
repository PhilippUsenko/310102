package main

import main.models.*

fun main() {
    // Создаем объект директора
    val director = Director(name = "Валерия")
    // Объект компании
    val company = Company(name = "TechCorp", tasks = 0, budget = 10000.0)

    // 1. Директор -> управлять компанией
    director.manageCompany()
    println("Введите кол-во задач на сегодня: ")
    var tasks:Int
    while (true) {
        try {
            tasks = readln().toInt()
            if( tasks < 0 ){
                println("Введите натуральное число!")
            }
            break
        } catch (e: Exception) {
            println("Введите натуральное число!")
        }
    }
    // 2. Директор -> установить задачи
    director.setTasks(company, tasks)

    // 3. Компания -> нанять работника (программиста)
    val programmer = Programmer(name = "Иван")
    company.hireEmployee(programmer)

    // 4. Программист -> писать код
    val tasksCompleted = programmer.writeCode(company)

    // 5. Компания -> нанять работника (уборщика)
    val cleaner = Cleaner(name = "Сергей")
    company.hireEmployee(cleaner)

    // 6. Уборщик -> убирать
    cleaner.clean()

    // 7. Программист -> вернуть готовую задачу
    println("${programmer.name} выполнил $tasksCompleted из ${company.getTasks() + tasksCompleted} задач")

    // 8. Программист -> попросить увеличить зарплату
    var requestedMoney = programmer.askForRaise(tasksCompleted, tasks)

    // 9. Директор -> Вернуть новую зарплату
    director.returnNewSalary(requestedMoney)

    // 10. Директор -> премировать
    var bonusAmount: Double
    println("На какую сумму вы хотите премировать сотрудника: ${programmer.name}")
    while (true) {
        try {
            bonusAmount = readln().toDouble()
            // проверяем, что сумма премии положительна и не превышает доступный бюджет
            if(bonusAmount > 0 && bonusAmount <= company.getBudget() - requestedMoney){
                break
            }else{
                println("Введите натуральное число не больше ${company.getBudget() - requestedMoney}!")
            }
        } catch (e: Exception) {
            println("Введите натуральное число!")
        }
    }

    if(director.awardBonus(company, programmer, bonusAmount)){ //Проверяем, была ли успешно выдана премия
        requestedMoney += bonusAmount
    }

    // 11. Программист -> Получить зарплату()
    // 12. Программист -> Попросить перечислить деньги()
    println("${programmer.name} попросил перечислить зарплату: $requestedMoney")

    // 13. Компания -> Вернуть деньги
    company.transferMoney(programmer, requestedMoney)
}