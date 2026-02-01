plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.graphql.kotlin) apply false
    alias(libs.plugins.ktlint) apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    // Disable ktlint from build task (keep it available for manual runs)
    tasks.matching { it.name.startsWith("ktlint") }.configureEach {
        enabled = false
    }
}
