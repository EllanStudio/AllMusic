java.sourceCompatibility = JavaVersion.VERSION_25
java.targetCompatibility = JavaVersion.VERSION_25

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

sourceSets {
    named("main") {
        java.srcDir("../paper/src/main/java")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.3.build.157-beta")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7.1")
    compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly("net.kyori:adventure-text-minimessage:${Versions.minimessage}")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }

    shadowJar {
        archiveFileName.set("[paper-26.3]AllMusic_Server-${project.version}.jar")
        destinationDirectory.set(file("${parent!!.projectDir}/../build"))
    }
}
