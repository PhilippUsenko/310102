public struct CarNumbers {
    public static func countSpecialNumbers(in numbers: [String]) -> Int {
        return numbers.filter { number in
            guard Validation.isValidCarNumber(number) else { return false }
            let digitCounts = Dictionary(number.map { ($0, 1) }, uniquingKeysWith: +)
            return digitCounts.values.contains(where: { $0 >= 3 })
        }.count
    }
}
