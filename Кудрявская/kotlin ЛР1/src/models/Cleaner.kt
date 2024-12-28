package main.models

class Cleaner(name: String) : Employee(name) {
    fun clean() {
        println("$name убирает помещение")
    }
}
