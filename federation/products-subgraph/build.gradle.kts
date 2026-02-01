import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "An example spring service for federation that implements product type"

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
    testImplementation(libs.kotlin.junit.test)
    testImplementation(libs.spring.boot.test)

    graphqlSDL("com.expediagroup:graphql-kotlin-federated-hooks-provider:${libs.versions.graphql.kotlin.get()}")
}

// config below is to simplify dockerfile
tasks.named("build") {
    dependsOn("bootJar")
    dependsOn("graphqlGenerateSDL")
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    archiveFileName.set("products-subgraph.jar")
}

graphql {
    schema {
        packages = listOf("com.expediagroup.graphql.examples.federation.products")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

kotlin {
    jvmToolchain(21)
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
