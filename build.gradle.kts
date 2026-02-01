buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.expediagroup:graphql-kotlin-gradle-plugin:8.8.1")
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}
