package main.models

//класс Company с тремя параметрами: name, tasks и budget
class Company(
    private val name: String,
    private var tasks: Int,
    private var budget: Double
) {
    //  список сотрудников, который может изменяться
    private val employees = mutableListOf<Employee>()

    fun decreaseTasks(completedTasks: Int) {
        tasks -= completedTasks
        if (tasks < 0) tasks = 0
    }

    fun getTasks(): Int {
        return tasks
    }

    fun getBudget(): Double{
        return budget
    }

    // Метод для найма нового сотрудника
    fun hireEmployee(employee: Employee) {
        employees.add(employee)
        println("${employee.name} нанят в компанию $name")
    }

    // для перевода денег сотруднику
    fun transferMoney(employee: Employee, amount: Double): Boolean {
        return if (budget >= amount) {
            budget -= amount
            employee.receiveSalary(amount)
            println("Компания перевела $amount ${employee.name}. Остаток бюджета: $budget")
            true
        } else {
            println("Недостаточно средств в бюджете компании для перевода $amount. Бюджет: $budget")
            false
        }
    }

    fun setTasks(newTasks: Int) {
        tasks = newTasks
    }

}