package pets

class Shepherd(age: Int, name: String) : Dog(age, name) {
    override fun makeSound() {
        println("Овчарка $name гавкает")
    }

    override fun executeCommand(command: String) {
        println("Овчарка $name выполняет команду: $command")
    }

    override fun askForFood() {
        println("Овчарка $name просит корм.")
    }

    override fun acceptCommand(command: String) {
        println("Овчарка $name принял команду: $command")
    }
}