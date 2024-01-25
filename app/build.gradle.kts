import dependencies.dependency.addAndroLifeCycleDependencies
import dependencies.dependency.addAndroidComposeDependencies
import dependencies.dependency.addAndroidTestsDependencies
import dependencies.dependency.addCoroutinesAndroidDependencies
import dependencies.dependency.addKoinDependencies
import dependencies.dependency.addLeakcanaryDependencies
import dependencies.dependency.addMoshi
import dependencies.dependency.addNavigationDependencies
import dependencies.dependency.addNetworkDependencies
import dependencies.dependency.addRoomDependencies
import dependencies.dependency.addTimberDependencies
import dependencies.module.addCommonModule
import dependencies.module.addDataModule
import dependencies.module.addDiModule
import dependencies.module.addDomainModule
import dependencies.module.addModelModule

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdkVersion
    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    addDataModule()
    addDomainModule()
    addDiModule()
    addCommonModule()
    addModelModule()

    addAndroLifeCycleDependencies()
    addNavigationDependencies()

    addCoroutinesAndroidDependencies()
    addKoinDependencies()

    addNetworkDependencies()
    addMoshi()
    addRoomDependencies()

    addLeakcanaryDependencies()
    addTimberDependencies()
    addAndroidTestsDependencies()
}