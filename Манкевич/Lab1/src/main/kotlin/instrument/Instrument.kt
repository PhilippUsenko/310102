package instrument

import product.Product
import product.Workpiece

// Измененный абстрактный класс Instrument, метод принимает vararg Workpiece
abstract class Instrument(val weight: Double) {
    abstract fun work(vararg workpieces: Workpiece)
}

class Saw(private val length: Double, weight: Double) : Instrument(weight) {

    private fun sawing() {
        println("Sawing")
    }

    // Реализуем работу с переменным количеством заготовок
    override fun work(vararg workpieces: Workpiece) {
        println("Saw is used")
        sawing()
        workpieces.forEach { it.changeShapeRequest("cut") }
    }
}

class Plane(weight: Double) : Instrument(weight) {
    private fun planing() {
        println("Planing")
    }

    override fun work(vararg workpieces: Workpiece) {
        println("Plane is used")
        planing()
        workpieces.forEach { it.changeShapeRequest("smooth") }
    }
}

class Screwdriver(weight: Double) : Instrument(weight) {

    // Реализуем метод work для работы с переменным количеством заготовок
    override fun work(vararg workpieces: Workpiece) {
        println("Screwdriver is used")
        if (workpieces.size == 2) {
            // Скручиваем две заготовки
            screw(workpieces[0], workpieces[1])
        } else {
            println("Screwdriver requires two workpieces to operate.")
        }
    }

    // Функция скручивания двух заготовок
    fun screw(workpiece1: Workpiece, workpiece2: Workpiece): Product {
        println("${workpiece1.name} и ${workpiece2.name} screwed")
        val product = Product()
        product.setProductReady(true)
        return product
    }

    // Функция раскручивания двух заготовок
    fun unscrew(workpiece1: Workpiece, workpiece2: Workpiece, product: Product): Product {
        println("${workpiece1.name} и ${workpiece2.name} unscrewed")
        product.setProductReady(false)
        return product
    }
}
