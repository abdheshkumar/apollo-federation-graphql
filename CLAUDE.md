# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a multi-module GraphQL Kotlin examples repository demonstrating various server implementations (Spring Boot, Ktor), client usage (Gradle, Maven), and Apollo Federation patterns.

**Key Library**: graphql-kotlin v8.8.1
**Build System**: Gradle 8.8 with Kotlin DSL
**JVM Target**: Java 17

## Build Commands

### Essential Commands
```bash
./gradlew build              # Full build with tests and ktlint checks
./gradlew test               # Run all tests
./gradlew ktlintCheck        # Check code style (blocks build if violations found)
./gradlew ktlintFormat       # Auto-format code to fix ktlint violations
```

### Module-Specific Commands
```bash
# Build specific modules
./gradlew :spring-server:build
./gradlew :ktor-server:build
./gradlew :gradle-client-example:build
./gradlew :federation-products-subgraph:build

# Run servers
./gradlew :spring-server:bootRun         # Start Spring server on http://localhost:8080
./gradlew :ktor-server:run                # Start Ktor server

# Run clients (requires server running)
./gradlew :gradle-client-example:run
./gradlew :maven-client-example:mavenBuild

# GraphQL code generation
./gradlew :gradle-client-example:graphqlGenerateClient
./gradlew :federation-products-subgraph:graphqlGenerateSDL
```

### Testing
```bash
# Run tests for specific modules
./gradlew :spring-server:test
./gradlew :federation-products-subgraph:test

# Run single test class
./gradlew :spring-server:test --tests "SimpleQueryIT"
```

## Architecture

### Project Structure

The repository uses a flat Gradle project structure with directory mapping:

- **client/** - GraphQL client examples
  - `gradle-client/` → `:gradle-client-example` - Gradle plugin with Ktor client + kotlinx.serialization
  - `maven-client/` → `:maven-client-example` - Maven plugin with Spring WebClient
  - `server/` → `:server-client-example` - Simple Spring Boot server for clients to connect to

- **server/** - GraphQL server implementations
  - `spring-server/` → `:spring-server` - Spring Boot + WebFlux reactive server
  - `ktor-server/` → `:ktor-server` - Ktor-based server

- **federation/** - Apollo Federation examples
  - `products-subgraph/` → `:federation-products-subgraph` - Defines Product entity
  - `reviews-subgraph/` → `:federation-reviews-subgraph` - Extends Product with reviews

### Build Configuration

**Modern Gradle setup** (no buildSrc):
- Root `build.gradle.kts` declares plugins with `apply false`
- Version catalog in `gradle/libs.versions.toml` for dependency management
- Each module directly applies plugins and configures dependencies
- All modules include common configuration: Kotlin JVM 17, ktlint enforcement

**Important**: Code quality is enforced via ktlint. Build will fail on style violations.

### Client Code Generation

**Gradle Client**: Uses `com.expediagroup.graphql` plugin to generate Kotlin client code from GraphQL schema file at `client/src/integration/wiremock/__files/schema.graphql`. Generated code uses kotlinx.serialization.

**Maven Client**: Similar setup but invokes Maven via Gradle wrapper (`mvnw`), generating Spring WebClient compatible code.

**Schema Source**: Both clients read from static `schema.graphql` file (no runtime WireMock server needed).

### Server Architecture

**Spring Server** (`spring-server`):
- Uses `graphql-kotlin-spring-server` with WebFlux for reactive GraphQL
- Schema generated from Kotlin classes in `com.expediagroup.graphql.examples.server.spring`
- Includes DataLoader pattern examples (`CompanyDataLoader`)
- Custom directives, subscriptions (deprecated apollo-subscriptions-ws protocol)
- GraphiQL playground at http://localhost:8080/graphiql

**Ktor Server** (`ktor-server`):
- Uses `graphql-kotlin-ktor-server`
- Schema from `com.expediagroup.graphql.examples.server.ktor`
- Lightweight alternative to Spring

### Federation Pattern

Both subgraphs are Spring Boot apps:
- **products-subgraph**: Defines base `Product` type with `@key` directive
- **reviews-subgraph**: Extends `Product` with reviews field using `@extends`
- Use Apollo Router/Gateway (not included) to compose federated schema
- SDL generation: `./gradlew :federation-products-subgraph:graphqlGenerateSDL`

## Key Implementation Details

### Constant Naming
Use SCREAMING_SNAKE_CASE for constants in companion objects (ktlint enforced):
```kotlin
companion object {
    const val NAME = "CompanyDataLoader"  // ✓ Correct
    const val name = "CompanyDataLoader"  // ✗ Will fail ktlint
}
```

### GraphQL Typename Fields
Special fields like `__typename` need ktlint suppression:
```kotlin
@Suppress("ktlint:standard:backing-property-naming")
val __typename: String = "Product"
```

### Test Notes
- One test is disabled: `APQQueryIT.verify GET persisted query with hash only followed by POST with hash()`
  - Pre-existing issue with Automatic Persisted Queries returning 400 instead of JSON error
  - Marked with `@Disabled` annotation

### Code Quality
- ktlint configured to exclude generated code: `**/generated/**`
- No detekt (removed from build)
- All formatting violations must be fixed before build succeeds

## Module Dependencies

Client examples depend on `server-client-example` to be running. Start server first:
```bash
./gradlew :server-client-example:bootRun
# Then in another terminal:
./gradlew :gradle-client-example:run
```

## GitHub Actions

CI workflow in `.github/workflows/gradle.yml`:
- Runs on Ubuntu with Java 17 (Temurin)
- Executes `./gradlew build`
- Includes dependency submission for Dependabot
- Gradle wrapper JAR is committed (exception in `.gitignore`)
