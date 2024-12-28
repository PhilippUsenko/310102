// swift-tools-version: 5.10
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "task1",
    products: [
        .library(
            name: "task1",
            targets: ["task1"]),
    ],
    targets: [
        .target(
            name: "task1"),
        .testTarget(
            name: "task1LibTests",
            dependencies: ["task1"]),
    ]
)
