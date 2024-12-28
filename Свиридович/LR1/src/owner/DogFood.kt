package owner
import pets.Dog

class DogFood(private var quantity: Int) {
    fun feedDog(dog: pets.Dog) {
        if (quantity > 0) {
            println("Дайте ${dog.getDogName()} еду.")
            quantity--
        } else {
            println("Еды не осталось!")
        }
    }
}