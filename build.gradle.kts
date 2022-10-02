buildscript {
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Dependencies.BuildPlugins.androidApplication) version Versions.gradlePlugin apply false
    id (Dependencies.BuildPlugins.androidLibrary) version Versions.gradlePlugin apply false
    id (Dependencies.BuildPlugins.kotlinAndroid) version Versions.kotlin apply false
    id (Dependencies.BuildPlugins.kotlinJvm) version Versions.kotlin apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}