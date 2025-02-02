val kableVersion = "0.35.0"
val coroutinesVersion = "1.10.1"

plugins {
    id("com.android.application") version "8.8.0"// or id("com.android.library")
    kotlin("multiplatform") version "2.1.10"
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
            api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
            implementation("com.juul.kable:kable-core:${kableVersion}")
        }

        androidMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutinesVersion}")
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