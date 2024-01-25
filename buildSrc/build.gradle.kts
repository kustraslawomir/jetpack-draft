import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")
    }
    extra.apply {
        set("kotlinVersion", project.properties["kotlinVersion"])
        set("koinVersion", System.getProperty("koinVersion"))
        set("androidGradlePluginVersion", project.properties["androidGradlePluginVersion"])
        set("navigationComposeVersion", project.properties["navigationComposeVersion"])
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven("https://jitpack.io")
    maven("https://oss.jfrog.org/libs-snapshot")
}


dependencies {
    implementation("com.android.tools.build:gradle:${project.properties["androidGradlePluginVersion"]}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${project.properties["kotlinVersion"]}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${project.properties["navigationComposeVersion"]}")
}