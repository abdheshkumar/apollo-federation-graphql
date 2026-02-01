import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "An example GraphQL Spring server"

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.graphql.kotlin)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlinx.coroutines.jdk8)
    implementation(libs.icu)
    implementation("com.expediagroup:graphql-kotlin-spring-server:${libs.versions.graphql.kotlin.get()}")
    implementation("com.expediagroup:graphql-kotlin-hooks-provider:${libs.versions.graphql.kotlin.get()}")
    implementation(libs.spring.boot.validation)
    testImplementation(libs.kotlin.junit.test)
    testImplementation(libs.spring.boot.test)
    testImplementation(libs.reactor.test)
}

graphql {
    schema {
        packages = listOf("com.expediagroup.graphql.examples.server.spring")
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
}
