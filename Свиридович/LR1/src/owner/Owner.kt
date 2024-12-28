package owner

import pets.*

class Owner {
    fun adoptDog(breed: String, age: Int, name: String): Dog {
        return when (breed.lowercase()) {
            "пудель" -> Poodle(age, name)
            "терьер" -> Terrier(age, name)
            "овчарка" -> Shepherd(age, name)
            else -> throw IllegalArgumentException("Неизвестная порода: $breed")
        }
    }

    fun adoptCat(age: Int, name: String): Cat {
        return Cat(age, name)
    }

    fun walkDog(dog: Dog) {
        println("Выгуливаем собаку: ${dog.getDogName()}")
    }

    fun giveCommand(dog: Dog, command: String) {
        dog.executeCommand(command)
    }

    fun feedDog(dog: Dog) {
        dog.askForFood()
    }
}