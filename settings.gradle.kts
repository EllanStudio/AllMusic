rootProject.name = "AllMusic"

// CI can select one compatibility scope so an unrelated legacy plugin cannot
// prevent a focused client, server, or one-jar build from configuring.
val allmusicScope = providers.gradleProperty("allmusic.scope").orNull
val scopedProjects: Set<String>? = when (allmusicScope) {
    "legacy-client" -> setOf(":codec", ":client", ":client:fabric_1_20_1")
    "client-26.2" -> setOf(":codec", ":client", ":client:fabric_26_2")
    "modern-client-26.3" -> setOf(":codec", ":client", ":client:fabric_26_3", ":client:neoforge_26_3")
    "legacy-server" -> setOf(":codec", ":server", ":server:paper")
    "server-all" -> setOf(
        ":codec", ":server",
        ":server:fabric_1_16_5", ":server:fabric_1_20_1", ":server:fabric_1_21",
        ":server:fabric_1_21_4", ":server:fabric_1_21_6", ":server:fabric_1_21_11",
        ":server:fabric_26_1", ":server:fabric_26_2", ":server:fabric_26_3",
        ":server:neoforge_1_21", ":server:neoforge_1_21_4",
        ":server:neoforge_1_21_6", ":server:neoforge_1_21_11",
        ":server:neoforge_26_1", ":server:neoforge_26_2", ":server:neoforge_26_3",
        ":server:spigot", ":server:paper", ":server:folia",
        ":server:bungeecord", ":server:velocity",
        ":server:paper_26_3", ":server:folia_26_3",
        ":server:spigot_26_3", ":server:velocity_26_3"
    )
    "modern-server-26.3" -> setOf(
        ":codec", ":server", ":server:fabric_26_3", ":server:neoforge_26_3",
        ":server:paper_26_3", ":server:folia_26_3",
        ":server:spigot_26_3", ":server:velocity_26_3"
    )
    "onejar-26.3" -> setOf(
        ":codec", ":client", ":server", ":onejar",
        ":client:fabric_26_3", ":client:neoforge_26_3",
        ":server:fabric_26_3", ":server:neoforge_26_3",
        ":onejar:fabric_26_3", ":onejar:neoforge_26_3"
    )
    else -> null
}

fun includeProject(path: String) {
    if (scopedProjects == null || path in scopedProjects) include(path)
}

includeProject(":codec")

includeProject(":client")

includeProject(":client:fabric_1_16_5")
includeProject(":client:fabric_1_20_1")
includeProject(":client:fabric_1_21")
includeProject(":client:fabric_1_21_3")
includeProject(":client:fabric_1_21_4")
includeProject(":client:fabric_1_21_6")
includeProject(":client:fabric_1_21_8")
includeProject(":client:fabric_1_21_11")
includeProject(":client:fabric_26_1")
includeProject(":client:fabric_26_2")
includeProject(":client:fabric_26_3")

includeProject(":client:forge_1_7_10")
includeProject(":client:forge_1_12_2")
includeProject(":client:forge_1_16_5")
includeProject(":client:forge_1_20_1")

includeProject(":client:neoforge_1_21")
includeProject(":client:neoforge_1_21_3")
includeProject(":client:neoforge_1_21_4")
includeProject(":client:neoforge_1_21_6")
includeProject(":client:neoforge_1_21_11")
includeProject(":client:neoforge_26_1")
includeProject(":client:neoforge_26_2")
includeProject(":client:neoforge_26_3")

includeProject(":server")

includeProject(":server:fabric_1_16_5")
includeProject(":server:fabric_1_20_1")
includeProject(":server:fabric_1_21")
includeProject(":server:fabric_1_21_4")
includeProject(":server:fabric_1_21_6")
includeProject(":server:fabric_1_21_11")
includeProject(":server:fabric_26_1")
includeProject(":server:fabric_26_2")

includeProject(":server:forge_1_7_10")
includeProject(":server:forge_1_12_2")
includeProject(":server:forge_1_16_5")
includeProject(":server:forge_1_20_1")

includeProject(":server:neoforge_1_21")
includeProject(":server:neoforge_1_21_4")
includeProject(":server:neoforge_1_21_6")
includeProject(":server:neoforge_1_21_11")
includeProject(":server:neoforge_26_1")
includeProject(":server:neoforge_26_2")
includeProject(":server:fabric_26_3")
includeProject(":server:neoforge_26_3")

includeProject(":server:spigot")
includeProject(":server:paper")
includeProject(":server:folia")
includeProject(":server:paper")
includeProject(":server:bungeecord")
includeProject(":server:velocity")

// Minecraft 26.3 Bukkit-family adapters; legacy server modules above remain unchanged.
includeProject(":server:paper_26_3")
includeProject(":server:folia_26_3")
includeProject(":server:spigot_26_3")
includeProject(":server:velocity_26_3")

includeProject(":onejar")

includeProject(":onejar:fabric_1_16_5")
includeProject(":onejar:fabric_1_20_1")
includeProject(":onejar:fabric_1_21")
includeProject(":onejar:fabric_1_21_4")
includeProject(":onejar:fabric_1_21_6")
includeProject(":onejar:fabric_1_21_11")
includeProject(":onejar:fabric_26_1")
includeProject(":onejar:fabric_26_2")

includeProject(":onejar:neoforge_1_21")
includeProject(":onejar:neoforge_1_21_4")
includeProject(":onejar:neoforge_1_21_6")
includeProject(":onejar:neoforge_1_21_11")
includeProject(":onejar:neoforge_26_1")
includeProject(":onejar:neoforge_26_2")
includeProject(":onejar:fabric_26_3")
includeProject(":onejar:neoforge_26_3")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.neoforged.net/releases/")
        maven("https://maven.architectury.dev/")
        maven("https://nexus.gtnewhorizons.com/repository/public/")
    }
}
