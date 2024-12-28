package pets

abstract class Pet(protected val age: Int, protected val name: String) {
     abstract fun makeSound()
}