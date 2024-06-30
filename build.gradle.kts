group = "net.turniptales"
version = "1.0.0"
description = "TurnipTales Libraries"

java.sourceCompatibility = JavaVersion.VERSION_21

plugins {
    id("java-library")
    id("io.papermc.paperweight.userdev") version "1.7.1"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenLocal()
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://maven.citizensnpcs.co/repo")
    maven("https://jitpack.io")
    maven("https://repo.maven.apache.org/maven2/")
    maven("https://maven.rettichlp.de/releases")
}

dependencies {
    api("org.springframework", "spring-web", "6.1.10")
    api("org.springframework", "spring-webflux", "6.1.8")
    api("com.google.code.gson", "gson", "2.11.0")
    api("com.google.inject", "guice", "7.0.0")
    api("com.jeff-media", "json-configuration-serialization", "1.1.4")
    api("de.rettichlp", "dclogging", "1.1.5")

    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT")
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    withType<Javadoc> {
        options.encoding = "UTF-8"
    }

    shadowJar {
        archiveFileName.set("turniptales-libraries.jar")
    }

}
