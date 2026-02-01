import com.expediagroup.graphql.plugin.gradle.config.GraphQLScalar
import com.expediagroup.graphql.plugin.gradle.config.GraphQLSerializer
import com.expediagroup.graphql.plugin.gradle.graphql
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "Example usage of Gradle plugin to generate GraphQL Kotlin Client"

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.graphql.kotlin)
    alias(libs.plugins.kotlin.serialization)
    application
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlinx.coroutines.jdk8)
    implementation(libs.icu)
    implementation("com.expediagroup:graphql-kotlin-ktor-client:${libs.versions.graphql.kotlin.get()}")
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.jvm.logging)
    testImplementation(libs.kotlin.junit.test)
}

application {
    mainClass.set("com.expediagroup.graphql.examples.client.gradle.ApplicationKt")
}

graphql {
    client {
        packageName = "com.expediagroup.graphql.generated"
        // using direct schema file instead of HTTP endpoint
        schemaFile = file("${project.rootProject.projectDir}/client/src/integration/wiremock/__files/schema.graphql")

        // optional
        allowDeprecatedFields = true
        headers = mapOf("X-Custom-Header" to "My-Custom-Header")
        customScalars =
            listOf(
                GraphQLScalar(
                    "_Any",
                    "kotlinx.serialization.json.JsonObject",
                    "com.expediagroup.graphql.examples.client.gradle.AnyScalarConverter",
                ),
                GraphQLScalar(
                    "Locale",
                    "com.ibm.icu.util.ULocale",
                    "com.expediagroup.graphql.examples.client.gradle.ULocaleScalarConverter",
                ),
                GraphQLScalar(
                    "UUID",
                    "java.util.UUID",
                    "com.expediagroup.graphql.examples.client.gradle.UUIDScalarConverter",
                ),
            )
        serializer = GraphQLSerializer.KOTLINX
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
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
    version.set(
        libs.versions.ktlint.core
            .get(),
    )
    filter {
        exclude("**/generated/**")
    }
}
