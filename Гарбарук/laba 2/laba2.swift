import Foundation

struct MathOperations {
    static let subtractIntegers: (Int, Int) -> Int = { $0 - $1 }
}
struct CarNumbers {
    static func countSpecialNumbers(in numbers: [String]) -> Int {
        return numbers.filter { number in
            guard Validation.isValidCarNumber(number) else { return false }
            let digitCounts = Dictionary(number.map { ($0, 1) }, uniquingKeysWith: +)
            return digitCounts.values.contains(where: { $0 >= 3 })
        }.count
    }
}

struct Complex {
    let real: Double
    let imaginary: Double
    
    func subtract(_ other: Complex) -> Complex {
        return Complex(real: self.real - other.real, imaginary: self.imaginary - other.imaginary)
    }
}
struct Validation {
    static func isValidCarNumber(_ number: String) -> Bool {
        let pattern = "^[0-9]{4}$" // Шаблон для четырехзначного номера
        let regex = try? NSRegularExpression(pattern: pattern)
        return regex?.firstMatch(in: number, options: [], range: NSRange(location: 0, length: number.count)) != nil
    }
}
let carNumbers = ["1122", "3333", "1244", "5555", "9876"]
let specialNumbersCount = CarNumbers.countSpecialNumbers(in: carNumbers)
print("Kol-vo nomerov c tremya i bolee odinakovymi ciframi: \(specialNumbersCount)")

// Пример вычитания целых чисел
let intResult = MathOperations.subtractIntegers(10, 4)
print("Resultat vychitaniya celyh chisel: \(intResult)")

// Пример вычитания комплексных чисел
let complex1 = Complex(real: 5.0, imaginary: 3.0)
let complex2 = Complex(real: 2.0, imaginary: 1.0)
let complexResult = complex1.subtract(complex2)
print("Resultat vychitaniya complexnyh chisel: \(complexResult.real) + \(complexResult.imaginary)i")