// The Swift Programming Language
// https://docs.swift.org/swift-boo

import task1
import task2

import Foundation

let hexToBinaryMap: [Character: String] = [
    "0": "0000", "1": "0001", "2": "0010", "3": "0011",
    "4": "0100", "5": "0101", "6": "0110", "7": "0111",
    "8": "1000", "9": "1001", "A": "1010", "B": "1011",
    "C": "1100", "D": "1101", "E": "1110", "F": "1111"
]

// Функция для перевода шестнадцатеричной строки в двоичную
func hexToBinary(_ hex: String) -> String {
    var binaryResult = ""
    
    // Проходим по каждому символу в строке
    for char in hex.uppercased() {
        // Находим двоичное представление для текущего символа и добавляем к результату
        if let binaryValue = hexToBinaryMap[char] {
            binaryResult += binaryValue
        } else {
            print("Недопустимый символ: \(char)")
            return ""
        }
    }
    
    // Убираем ведущие нули
    if let firstNonZeroIndex = binaryResult.firstIndex(where: { $0 != "0" }) {
        return String(binaryResult[firstNonZeroIndex...])
    }
    
    // Если все нули (например, число было 0)
    return "0"
}

// Функция для взаимодействия с пользователем
func main() {
    // Пример использования
    print("Введите шестнадцатеричное число:")
    if let hexNumber = readLine() {
        let binaryResult = hexToBinary(hexNumber)
        print("Шестнадцатеричное число \(hexNumber) в двоичной системе: \(binaryResult)")
    } else {
        print("Ошибка ввода!")
    }
    
    // Ввод десятичных дробей
    print("Введите первую десятичную дробь:")
    guard let decimal1 = Double(readLine() ?? "") else {
        print("Некорректный ввод. Попробуйте снова.")
        return
    }

    print("Введите вторую десятичную дробь:")
    guard let decimal2 = Double(readLine() ?? "") else {
        print("Некорректный ввод. Попробуйте снова.")
        return
    }

    let decimalResult = multiplyDecimals(decimal1, decimal2)
    print("Результат умножения десятичных дробей: \(decimalResult)")
    
    // Ввод обыкновенных дробей
    print("Введите числитель первой обыкновенной дроби:")
    guard let numerator1 = Int(readLine() ?? "") else {
        print("Некорректный ввод. Попробуйте снова.")
        return
    }

    print("Введите знаменатель первой обыкновенной дроби:")
    guard let denominator1 = Int(readLine() ?? ""), denominator1 != 0 else {
        print("Некорректный ввод. Знаменатель не может быть нулем.")
        return
    }

    let fraction1 = Fraction(numerator: numerator1, denominator: denominator1)

    print("Введите числитель второй обыкновенной дроби:")
    guard let numerator2 = Int(readLine() ?? "") else {
        print("Некорректный ввод. Попробуйте снова.")
        return
    }

    print("Введите знаменатель второй обыкновенной дроби:")
    guard let denominator2 = Int(readLine() ?? ""), denominator2 != 0 else {
        print("Некорректный ввод. Знаменатель не может быть нулем.")
        return
    }

    let fraction2 = Fraction(numerator: numerator2, denominator: denominator2)

    let fractionResult = multiplyFractions(fraction1, fraction2)
    print("Результат умножения обыкновенных дробей: \(fractionResult.numerator)/\(fractionResult.denominator)")
}
main()