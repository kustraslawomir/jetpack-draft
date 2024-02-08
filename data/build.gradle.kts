import dependencies.dependency.addCoroutinesDependencies
import dependencies.dependency.addKoinDependencies
import dependencies.dependency.addNetworkDependencies
import dependencies.dependency.addRoomDependencies
import dependencies.module.addCommonModule
import dependencies.module.addModelModule

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "skustra.dark.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    addModelModule()
    addCommonModule()

    addKoinDependencies()
    addNetworkDependencies()
    addRoomDependencies()
    addCoroutinesDependencies()
}