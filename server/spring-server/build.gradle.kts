description = "An example GraphQL Spring server"

plugins {
    id("com.expediagroup.graphql.examples.conventions")
    id("com.expediagroup.graphql")
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-server:${libs.versions.graphql.kotlin.get()}")
    implementation("com.expediagroup:graphql-kotlin-hooks-provider:${libs.versions.graphql.kotlin.get()}")
    implementation(libs.spring.boot.validation)
    testImplementation(libs.spring.boot.test)
    testImplementation(libs.reactor.test)
}

graphql {
    schema {
        packages = listOf("com.expediagroup.graphql.examples.server.spring")
    }
}
