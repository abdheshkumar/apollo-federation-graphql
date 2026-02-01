plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.graphql.kotlin) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.detekt) apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}
