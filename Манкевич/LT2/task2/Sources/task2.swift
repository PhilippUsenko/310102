// Модуль FractionMultiplication
public struct Fraction {
    public var numerator: Int
    public var denominator: Int
    public init(numerator: Int, denominator: Int) {
        self.denominator = denominator
        self.numerator = numerator
    }
}

public func multiplyFractions(_ frac1: Fraction, _ frac2: Fraction) -> Fraction {
    let numerator = frac1.numerator * frac2.numerator
    let denominator = frac1.denominator * frac2.denominator
    return Fraction(numerator: numerator, denominator: denominator)
}
