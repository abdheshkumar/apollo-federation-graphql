import java.time.Duration

description = "Example usage of Maven plugin to generate GraphQL Kotlin Client"

plugins {
    id("com.expediagroup.graphql.examples.conventions")
}

dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-client:${libs.versions.graphql.kotlin.get()}")
}

tasks {
    /* Gradle is used to invoke maven wrapper */
    val mavenEnvironmentVariables = mapOf(
        "graphqlKotlinVersion" to "8.8.1",
        "kotlinJvmTarget" to "17",
        "kotlinVersion" to "2.1.0",
        "kotlinxCoroutinesVersion" to "1.10.1",
        "reactorVersion" to "3.7.1"
    )
    val wireMockServerPort: Int? = ext.get("wireMockServerPort") as? Int
    val mavenBuild by register("mavenBuild") {
        timeout.set(Duration.ofSeconds(500))
        doLast {
            exec {
                environment(mavenEnvironmentVariables)
                environment("graphqlEndpoint", "http://localhost:$wireMockServerPort/sdl")
                commandLine("${project.projectDir}/mvnw", "clean", "verify", "--no-transfer-progress")
            }
        }
    }
    check {
        dependsOn(mavenBuild.path)
    }
}

// below configuration added so it compiles nicely in intellij
sourceSets {
    findByName("main")?.java?.srcDir("${project.projectDir}/target/generated-sources/graphql")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    dependsOn("mavenBuild")
}
ktlint {
    filter {
        exclude("**/generated/**")
    }
}
