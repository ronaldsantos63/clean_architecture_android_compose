pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "de.mannodermaus.android-junit5") {
                useModule("de.mannodermaus.gradle.plugins:android-junit5:${requested.version}")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Clean Architecture - Android Compose"
include(":app")
include(":domain")
include(":data")
include(":device")
