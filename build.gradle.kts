plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
}

repositories {
    mavenCentral()
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlin.coroutines.core)
            implementation(libs.kable)
        }

        androidMain.dependencies {
            implementation(libs.kotlin.coroutines.android)
        }
    }
}

android {
    compileSdk= 35
    namespace = "com.athlos.core"
    defaultConfig {
        targetSdk = 35
    }
}