import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktorVersion = "2.1.3"
val jacksonDatatypeVersion = "2.14.0"
val logbackClassicVersion = "1.4.4"
val assertjVersion = "3.23.1"
val restAssuredVersion = "5.2.0"
val junitVersion = "5.9.0"

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "io.aabdrashitov"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-jackson:$ktorVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonDatatypeVersion")
    implementation("ch.qos.logback:logback-classic:$logbackClassicVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("io.rest-assured:rest-assured:$restAssuredVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("io.aabdrashitov.tweetler.ApplicationKt")
}