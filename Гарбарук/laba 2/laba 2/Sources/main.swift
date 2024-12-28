
import Foundation
let carNumbers = ["1122", "3333", "1244", "5555", "9876"]
let specialNumbersCount = CarNumbers.countSpecialNumbers(in: carNumbers)
print("Kol-vo nomerov c tremya i bolee odinakovymi ciframi: \(specialNumbersCount)")

let intResult = MathOperations.subtractIntegers(10, 4)
print("Resultat vychitaniya celyh chisel: \(intResult)")

let complex1 = Complex(real: 5.0, imaginary: 3.0)
let complex2 = Complex(real: 2.0, imaginary: 1.0)
let complexResult = complex1.subtract(complex2)
print("Resultat vychitaniya complexnyh chisel: \(complexResult.real) + \(complexResult.imaginary)i")