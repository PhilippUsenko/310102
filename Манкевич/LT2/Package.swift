// swift-tools-version: 6.0
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "Lab2",
    dependencies :[
        .package(path:"./task1"),
        .package(path:"./task2"),
        
    ],
    targets: [
        // Targets are the basic building blocks of a package, defining a module or a test suite.
        // Targets can depend on other targets in this package and products from dependencies.
        .executableTarget(
            name: "Lab2",
            dependencies: ["task1","task2"]
            ),
    ]
)
