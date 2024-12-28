package worker

import instrument.Instrument
import instrument.Screwdriver
import product.Product
import product.Workpiece

class Worker(private val name: String) {
    fun work(instrument: Instrument, workpiece: Workpiece) {
        println("Worker $name uses the ${instrument::class.simpleName}")
        instrument.work(workpiece)
    }

    fun work(screwdriver: Screwdriver, workpiece1: Workpiece, workpiece2: Workpiece): Product {
        println("Worker $name uses the screwdriver")
        return screwdriver.screw(workpiece1, workpiece2)
    }

    fun work(screwdriver: Screwdriver, product: Product): Product {
        println("Worker $name uses the screwdriver to unscrew the product.")
        return screwdriver.unscrew(workpiece1 = Workpiece("piece1"), workpiece2 = Workpiece("piece2"), product)
    }
}
