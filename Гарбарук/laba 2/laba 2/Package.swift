// swift-tools-version: 6.0
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "laba2",
    products: [
        .executable(name: "laba2", targets: ["laba2"]),
    ],
    targets: [
        .executableTarget(
            name: "laba2",
            dependencies: []
        ),
    ]
)
