package main.models

class Director(name: String) : Employee(name) {

    fun manageCompany() {
        println("$name управляет компанией")
    }

    fun awardBonus(company: Company, employee: Employee, bonus: Double):Boolean {
        // Проверяем, достаточно ли бюджета компании для премии
        if (company.getBudget() >= bonus) {
            println("Директор премировал ${employee.name} на сумму: $bonus.")
            return true // Возвращаем true, если премия была выдана
        }
        println("У компании недостаточно бюджета для данной премии")
        return false
    }

    fun setTasks(company: Company, tasks: Int) {
        company.setTasks(tasks) // Устанавливаем задачи в компании с помощью метода setTasks
        println("$name установила задачи в количестве $tasks")
    }

    fun returnNewSalary(raise: Double) {
        if (raise > 100.0) {
            println("Директор одобрил повышение зарплаты на сумму: $raise")
        } else {
            println("Директор отклонил просьбу о повышении зарплаты.")
        }
    }
}