import io.papermc.paperweight.tasks.RemapJar

group = "net.turniptales"
version = "1.0.0"
description = "TurnipTales Libaries"

java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    id("java-library")
    id("io.papermc.paperweight.userdev") version "1.5.11"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenLocal()
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://maven.citizensnpcs.co/repo")
    maven("https://jitpack.io")
    maven("https://repo.maven.apache.org/maven2/")
}

dependencies {
    api("org.springframework", "spring-web", "6.1.2")
    api("org.springframework", "spring-webflux", "6.1.2")
    api("com.google.code.gson", "gson", "2.10.1")
    api("com.google.inject", "guice", "5.1.0")
    api("com.jeff-media", "json-configuration-serialization", "1.1.4")
    // https://mvnrepository.com/artifact/net.dv8tion/JDA
    api("net.dv8tion", "JDA", "5.0.0-beta.20")

    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    withType<Javadoc> {
        options.encoding = "UTF-8"
    }

    withType<RemapJar> {
        outputJar.set(layout.buildDirectory.file("libs/turniptales-libraries.jar"))
    }

    assemble {
        dependsOn(reobfJar)
    }

}
