import instrument.Plane
import instrument.Saw
import instrument.Screwdriver
import product.Product
import product.Workpiece
import worker.Worker

fun main(args: Array<String>) {
    println("Enter your name:")
    val nameFromConsole = readln()
    val workpiece1 = Workpiece(name = "piece1")
    val workpiece2 = Workpiece(name = "piece2")
    val worker = Worker(nameFromConsole)
    var product: Product? = null
    while (true) {
        println("=============================================")
        println("Choose an instrument:")
        println("1. Saw")
        println("2. Plane")
        println("3. Screwdriver")
        println("4. Exit")

        val choose: Int = try {
            readln().toInt()
        } catch (ex: Exception) {
            println("Error: Invalid input.")
            continue
        }

        if (choose !in 1..4) {
            println("Error: Choose a valid option (1-4).")
            continue
        }

        when (choose) {
            1 -> {
                println("Enter the length of the saw in meters:")
                val length: Double = try {
                    readln().toDouble()
                } catch (ex: Exception) {
                    println("Error: Invalid input for length.")
                    continue
                }
                val instrument = Saw(length, length * 2)
                worker.work(instrument, workpiece1)
            }

            2 -> {
                println("Enter the weight of the plane:")
                val weight: Double = try {
                    readln().toDouble()
                } catch (ex: Exception) {
                    println("Error: Invalid input for weight.")
                    continue
                }
                val instrument = Plane(weight)
                worker.work(instrument, workpiece2)
            }

            3 -> {
                println("Enter the weight of the screwdriver:")
                val weight: Double = try {
                    readln().toDouble()
                } catch (ex: Exception) {
                    println("Error: Invalid input for weight.")
                    continue
                }

                val instrument = Screwdriver(weight)

                println("Choose action: 1 for screwing, 2 for unscrewing")
                val action = readln()

                when (action) {
                    "1" -> {
                        println("You chose to screw the workpieces together.")
                        product = worker.work(instrument, workpiece1, workpiece2)
                    }

                    "2" -> {
                        product?.let {
                            if (it.isReady()) {
                                println("You chose to unscrew the workpieces.")
                                worker.work(instrument, it)
                                product = null
                            } else {
                                println("Error: The product is not ready to unscrew.")
                            }
                        } ?: run {
                            println("Error: No product is available to unscrew.")
                        }
                    }

                    else -> {
                        println("Invalid option. Please choose 1 or 2.")
                    }
                }
            }

            4 -> {
                println("Exiting the program.")
                break
            }
        }
    }
}
