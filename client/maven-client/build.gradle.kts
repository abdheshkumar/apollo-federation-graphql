import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.Duration

description = "Example usage of Maven plugin to generate GraphQL Kotlin Client"

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlinx.coroutines.jdk8)
    implementation(libs.icu)
    implementation("com.expediagroup:graphql-kotlin-spring-client:${libs.versions.graphql.kotlin.get()}")
    testImplementation(libs.kotlin.junit.test)
}

tasks {
    // Gradle is used to invoke maven wrapper
    val mavenEnvironmentVariables =
        mapOf(
            "graphqlKotlinVersion" to "8.8.1",
            "kotlinJvmTarget" to "17",
            "kotlinVersion" to "2.1.0",
            "kotlinxCoroutinesVersion" to "1.10.1",
            "reactorVersion" to "3.7.1",
        )
    val mavenBuild by register("mavenBuild") {
        timeout.set(Duration.ofSeconds(500))
        doLast {
            exec {
                environment(mavenEnvironmentVariables)
                environment("graphqlSchemaFile", "${project.rootProject.projectDir}/client/src/integration/wiremock/__files/schema.graphql")
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

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
    dependsOn("mavenBuild")
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    enabled = false
}



ktlint {
    version.set(libs.versions.ktlint.core.get())
    filter {
        exclude("**/generated/**")
    }
}

