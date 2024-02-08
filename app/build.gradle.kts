import dependencies.dependency.addAndroLifeCycleDependencies
import dependencies.dependency.addMaterialDependencies
import dependencies.dependency.addAndroidTestsDependencies
import dependencies.dependency.addCoilImageLoadingDependencies
import dependencies.dependency.addComposeDependencies
import dependencies.dependency.addCoroutinesDependencies
import dependencies.dependency.addKoinDependencies
import dependencies.dependency.addLeakcanaryDependencies
import dependencies.dependency.addNavigationDependencies
import dependencies.module.addCommonModule
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

    addDomainModule()
    addModelModule()
    addDiModule()
    addCommonModule()

    addMaterialDependencies()
    addComposeDependencies()
    addAndroLifeCycleDependencies()
    addNavigationDependencies()
    addCoilImageLoadingDependencies()
    addKoinDependencies()
    addCoroutinesDependencies()

    addLeakcanaryDependencies()
    addAndroidTestsDependencies()
}