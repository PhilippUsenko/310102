package pets

class Cat(age: Int, name: String) : Pet(age, name) {
    override fun makeSound() {
        println("$name: Мяу!")
    }
    fun sleep() {
        println("$name спит.")
    }
}