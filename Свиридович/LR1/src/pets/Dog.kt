package pets

abstract class Dog(age: Int, name: String) : Pet(age, name) {
    private fun performCommand(command: String){}

    open fun executeCommand(command: String) {
        performCommand(command) // Вызов приватного метода
    }
    fun getDogName(): String {
        return name
    }
    abstract fun askForFood()
    abstract fun acceptCommand(command: String)
}