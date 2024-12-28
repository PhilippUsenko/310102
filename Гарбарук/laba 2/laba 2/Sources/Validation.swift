import Foundation
public struct Validation {
    public static func isValidCarNumber(_ number: String) -> Bool {
        let pattern = "^[0-9]{4}$"
        let regex = try? NSRegularExpression(pattern: pattern)
        return regex?.firstMatch(in: number, options: [], range: NSRange(location: 0, length: number.count)) != nil
    }
}
