import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    kotlin("android")
    id(Dependencies.BuildPlugins.androidJUnit5) version Versions.androidJUnit5
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.example.cleanarchitecture_androidcompose"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] = ConfigData.runnerBuilder
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        if (rootProject.file("signing-debug.properties").exists()) {
            val signingDebug = Properties()
            signingDebug.load(FileInputStream(rootProject.file("signing-debug.properties")))
            getByName("debug") {
                storeFile = rootProject.file(signingDebug.getProperty("storeFile"))
                storePassword = signingDebug.getProperty("storePassword")
                keyAlias = signingDebug.getProperty("keyAlias")
                keyPassword = signingDebug.getProperty("keyPassword")
            }
        }
        if (rootProject.file("signing-release.properties").exists()) {
            val signingRelease = Properties()
            signingRelease.load(FileInputStream(rootProject.file("signing-release.properties")))
            create("release") {
                storeFile = rootProject.file(signingRelease.getProperty("storeFile"))
                storePassword = signingRelease.getProperty("storePassword")
                keyAlias = signingRelease.getProperty("keyAlias")
                keyPassword = signingRelease.getProperty("keyPassword")
            }
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
            signingConfig = signingConfigs.getByName("debug")
        }

        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            isZipAlignEnabled = true
            isJniDebuggable = false
            isRenderscriptDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    lint {
        abortOnError = true
        ignoreWarnings = false
        quiet = true
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {

    implementation(Dependencies.Deps.coreKtx)
    implementation(Dependencies.Deps.composeUi)
    implementation(Dependencies.Deps.material3)
    implementation(Dependencies.Deps.composeUiToolingPreview)
    implementation(Dependencies.Deps.lifecycleRuntimeKtx)
    implementation(Dependencies.Deps.activityCompose)

    debugImplementation(Dependencies.Deps.uiTestTooling)
    debugImplementation(Dependencies.Deps.uiTestManifest)

    testImplementation(Dependencies.Deps.jUnit)
    testImplementation(Dependencies.Deps.jUnitJupiterApi)
    testRuntimeOnly(Dependencies.Deps.jUnitJupiterEngine)
    testImplementation(Dependencies.Deps.jUnitJupiterParams)
    testRuntimeOnly(Dependencies.Deps.jUnitVintageEngine)
    testImplementation(Dependencies.Deps.mockk)
    testImplementation(Dependencies.Deps.mockkAndroid)
    testImplementation(Dependencies.Deps.mockkAgent)

    androidTestImplementation(Dependencies.Deps.extJunit)
    androidTestImplementation(Dependencies.Deps.espressoCore)
    androidTestImplementation(Dependencies.Deps.uiTestJUnit)
    androidTestImplementation(Dependencies.Deps.testRunner)
    androidTestImplementation(Dependencies.Deps.jUnit5AndroidTestCore)
    androidTestRuntimeOnly(Dependencies.Deps.jUnit5AndroidTestRunner)
    androidTestImplementation(Dependencies.Deps.mockkAndroid)
    androidTestImplementation(Dependencies.Deps.mockkAgent)
}
