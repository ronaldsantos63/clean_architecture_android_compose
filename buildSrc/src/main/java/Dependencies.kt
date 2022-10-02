object Dependencies {
    object BuildPlugins {
        val androidApplication by lazy { "com.android.application" }
        val androidLibrary by lazy { "com.android.library" }
        val kotlinAndroid by lazy { "org.jetbrains.kotlin.android" }
        val kotlinJvm by lazy { "org.jetbrains.kotlin.jvm" }
        val androidJUnit5 by lazy { "de.mannodermaus.android-junit5" }
    }

    object Deps {
        val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
        val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
        val composeUi by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
        val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
        val material3 by lazy { "androidx.compose.material3:material3:${Versions.material3}" }
        val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
        val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }

        val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }

        val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
        val extJunit by lazy { "androidx.test.ext:junit:${Versions.extJUnit}" }
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
        val uiTestJUnit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
        val uiTestTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
        val uiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }
        val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
        val mockkAndroid by lazy { "io.mockk:mockk-android:${Versions.mockk}" }
        val mockkAgent by lazy { "io.mockk:mockk-agent:${Versions.mockk}" }
        val jUnitJupiterApi by lazy { "org.junit.jupiter:junit-jupiter-api:${Versions.jUnit5}" }
        val jUnitJupiterEngine by lazy { "org.junit.jupiter:junit-jupiter-engine:${Versions.jUnit5}" }
        val jUnitJupiterParams by lazy { "org.junit.jupiter:junit-jupiter-params:${Versions.jUnit5}" }
        val jUnitVintageEngine by lazy { "org.junit.vintage:junit-vintage-engine:${Versions.jUnit5}" }
        val testRunner by lazy { "androidx.test:runner:${Versions.testRunner}" }
        val jUnit5AndroidTestCore by lazy { "de.mannodermaus.junit5:android-test-core:${Versions.jUnit5Android}" }
        val jUnit5AndroidTestRunner by lazy { "de.mannodermaus.junit5:android-test-runner:${Versions.jUnit5Android}" }
    }
}
