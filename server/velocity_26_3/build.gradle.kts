java.sourceCompatibility = JavaVersion.VERSION_25
java.targetCompatibility = JavaVersion.VERSION_25

repositories {
    maven("https://nexus.velocitypowered.com/repository/maven-public/")
    maven("https://repo.papermc.io/repository/maven-public/")
}

sourceSets {
    named("main") {
        java.srcDir("../velocity/src/main/java")
    }
}

dependencies {
    // Velocity-only module: no Paper API is required.
    compileOnly("com.velocitypowered:velocity-api:4.2.1-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:4.2.1-SNAPSHOT")
    compileOnly("net.kyori:adventure-text-minimessage:${Versions.minimessage}")
}

tasks {
    processResources {
        filesMatching("velocity-plugin.json") {
            expand("version" to project.version)
        }
    }

    shadowJar {
        archiveFileName.set("[velocity-26.3]AllMusic_Server-${project.version}.jar")
        destinationDirectory.set(file("${parent!!.projectDir}/../build"))
    }
}
