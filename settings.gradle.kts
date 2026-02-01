rootProject.name = "graphql-kotlin-examples"

// Client examples
include("gradle-client-example")
include("maven-client-example")
include("server-client-example")

// Federation examples
include("federation-products-subgraph")
include("federation-reviews-subgraph")

// Server examples
include("spring-server")
include("ktor-server")

// Map to actual directories
project(":gradle-client-example").projectDir = file("client/gradle-client")
project(":maven-client-example").projectDir = file("client/maven-client")
project(":server-client-example").projectDir = file("client/server")

project(":federation-products-subgraph").projectDir = file("federation/products-subgraph")
project(":federation-reviews-subgraph").projectDir = file("federation/reviews-subgraph")

project(":spring-server").projectDir = file("server/spring-server")
project(":ktor-server").projectDir = file("server/ktor-server")
