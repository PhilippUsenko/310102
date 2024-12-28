package pets

class Terrier(age: Int, name: String) : Dog(age, name) {
    override fun makeSound() {
        println("Терьер $name гавкает")
    }

    override fun executeCommand(command: String) {
        println("Терьер $name выполняет команду: $command")
    }

    override fun askForFood() {
        println("Терьер $name просит корм.")
    }

    override fun acceptCommand(command: String) {
        println("Терьер $name принял команду: $command")
    }
}