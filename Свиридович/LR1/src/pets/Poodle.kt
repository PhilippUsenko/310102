package pets

class Poodle(age: Int, name: String) : Dog(age, name) {
    override fun makeSound() {
        println("Пудель $name гавкает")
    }

    override fun executeCommand(command: String) {
        println("Пудель $name выполняет команду: $command")
    }

    override fun askForFood() {
        println("Пудель $name просит корм.")
    }

    override fun acceptCommand(command: String) {
        println("Пудель $name принял команду: $command")
    }
}