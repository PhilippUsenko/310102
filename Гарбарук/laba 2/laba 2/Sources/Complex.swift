public struct Complex {
    public let real: Double
    public let imaginary: Double

    public func subtract(_ other: Complex) -> Complex {
        return Complex(real: self.real - other.real, imaginary: self.imaginary - other.imaginary)
    }
}
