java.sourceCompatibility = JavaVersion.VERSION_25
java.targetCompatibility = JavaVersion.VERSION_25

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

sourceSets {
    named("main") {
        java.srcDir("../folia/src/main/java")
    }
}

dependencies {
    // Folia 26.3 API is not published separately; compile the Folia-safe code against Paper 26.3.
    compileOnly("io.papermc.paper:paper-api:26.3.build.157-beta")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7.1")
    compileOnly("me.clip:placeholderapi:2.11.6")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }

    shadowJar {
        archiveFileName.set("[folia-26.3]AllMusic_Server-${project.version}.jar")
        destinationDirectory.set(file("${parent!!.projectDir}/../build"))
    }
}
