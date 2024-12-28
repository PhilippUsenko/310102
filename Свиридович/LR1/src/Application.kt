import pets.*
import owner.*
import java.util.Scanner

fun main() {
    val owner = Owner()
    val scanner = Scanner(System.`in`)
    var dog: Dog? = null
    var cat: Cat
    val dogFood = DogFood(5)

    while (true) {
        println("\nВыберите действие:")
        println("1. Завести собаку")
        println("2. Завести кошку")
        println("3. Дать команду собаке")
        println("4. Накормить собаку")
        println("5. Выгулять собаку")
        println("6. Выход")

        val choice = scanner.nextLine()

        when (choice) {
            "1" -> {
                println("Введите породу (пудель, терьер, овчарка):")
                val breed = scanner.nextLine()
                println("Введите возраст:")
                val age = scanner.nextLine().toInt()
                println("Введите кличку:")
                val name = scanner.nextLine()
                dog = owner.adoptDog(breed, age, name)
                println("Вы завели собаку: $name")
            }
            "2" -> {
                println("Введите возраст:")
                val age = scanner.nextLine().toInt()
                println("Введите кличку:")
                val name = scanner.nextLine()
                cat = owner.adoptCat(age, name)
                println("Вы завели кошку: $name")
                cat.makeSound()
                cat.sleep()
            }
            "3" -> {
                if (dog != null) {
                    println("Введите команду:")
                    val command = scanner.nextLine()
                    owner.giveCommand(dog, command)
                } else {
                    println("У вас нет собаки.")
                }
            }
            "4" -> {
                if (dog != null) {
                    owner.feedDog(dog)
                    dogFood.feedDog(dog)
                } else {
                    println("У вас нет собаки.")
                }
            }
            "5" -> {
                if (dog != null) {
                    owner.walkDog(dog)
                } else {
                    println("У вас нет собаки.")
                }
            }
            "6" -> {
                println("Выход из программы.")
                return
            }
            else -> {
                println("Неверный выбор. Пожалуйста, попробуйте снова.")
            }
        }
    }
}